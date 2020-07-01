package com.cloud.contentcenter.service.content;

import com.alibaba.fastjson.JSON;
import com.cloud.contentcenter.dto.ShareAuditDTO;
import com.cloud.contentcenter.dto.ShareDTO;
import com.cloud.contentcenter.dto.UserAddBonusMsgDTO;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.enums.AuditStatusEnum;
import com.cloud.contentcenter.feignclient.UserCenterFeignClient;
import com.cloud.contentcenter.mapper.RocketmqTransactionLogMapper;
import com.cloud.contentcenter.mapper.ShareMapper;
import com.cloud.contentcenter.model.RocketmqTransactionLog;
import com.cloud.contentcenter.model.Share;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 王峥
 * @date 2020/6/23 4:40 下午
 */
@Service
@Slf4j
public class ShareService {
    @Resource
    private ShareMapper shareMapper;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private UserCenterFeignClient userCenterFeignClient;
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private RocketmqTransactionLogMapper rocketmqTransactionLogMapper;
    @Resource
    private Source source;

    public ShareDTO findByid(Integer id) {

        Share share = this.shareMapper.selectByPrimaryKey(id);
        Integer userId = share.getUserId();
//        默认懒加载首次请求后才创建访问client导致首次加载过慢

        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
     /*   List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        List<String> targetURLs =  instances.stream()
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .collect(Collectors.toList());
        log.info("请求的目标地址:{}", targetURLs);
        UserDTO userDTO = restTemplate.getForObject(
                targetURL,
                UserDTO.class,
                userId
        );*/
        UserDTO userDTO = this.userCenterFeignClient.findById(userId);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

    public Share auditById(Integer id, ShareAuditDTO auditDTO) {
        Share share = this.shareMapper.selectByPrimaryKey(id);
        if (share == null) {
            throw new IllegalArgumentException("参数非法!该分享不存在!");
        }
        if (!Objects.equals("NOT_YET", share.getAuditStatus())) {
            throw new IllegalArgumentException("参数非法!该分享已经审核通过或者审核不通过!");
        }
//        如果是PASS,那么发送消息给Rockermq,让用户中心去消费并为发布人添加积分
        if (AuditStatusEnum.PASS.equals(auditDTO.getAuditStatusEnum())) {
            String transactionId = UUID.randomUUID().toString();
//            原rockerMQ写法
           /* this.rocketMQTemplate.sendMessageInTransaction(
                    "tx-add-bonus-group",
                    "add-bonus",
                    MessageBuilder.withPayload(
                            UserAddBonusMsgDTO.builder()
                                    .userId(share.getUserId())
                                    .bonus(50)
                                    .build()
                    )
//                            header
                            .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                            .setHeader("share_id", id)
                            .build(),
                    auditDTO
            );*/
//            Spring Cloud Stream 写法
            this.source.output()
                    .send(
                            MessageBuilder.withPayload(
                                    UserAddBonusMsgDTO.builder()
                                            .userId(share.getUserId())
                                            .bonus(50)
                                            .build()
                            )
                                    .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                                    .setHeader("share_id", id)
                                    .setHeader("dto", JSON.toJSONString(auditDTO))
                                    .build()
                    );
        } else {
            //        审核资源,将状态设为PASS/REJECT
            auditByIdInDB(auditDTO, id);
        }
//写入缓存
        return share;

    }

    public void auditByIdInDB(ShareAuditDTO auditDTO, Integer id) {
        Share share = Share.builder()
                .id(id)
                .auditStatus(auditDTO.getAuditStatusEnum().toString())
                .reason(auditDTO.getReason())
                .build();
        this.shareMapper.updateByPrimaryKeySelective(share);
    }

    @Transactional(rollbackFor = Exception.class)
    public void auditByIdWithRocketMqLog(Integer shareId, ShareAuditDTO shareAuditDTO, String id) {
        this.rocketmqTransactionLogMapper.insert(
                RocketmqTransactionLog.builder()
                        .transactionId(id)
                        .log("审核分享资源!")
                        .build()
        );
    }
}
