package com.cloud.contentcenter.service.content;

import com.cloud.contentcenter.dto.ShareAuditDTO;
import com.cloud.contentcenter.dto.ShareDTO;
import com.cloud.contentcenter.dto.UserAddBonusMsgDTO;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.UserCenterFeignClient;
import com.cloud.contentcenter.mapper.ShareMapper;
import com.cloud.contentcenter.model.Share;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        if (Objects.equals("NOT_YES", share.getAuditStatus())) {
            throw new IllegalArgumentException("参数非法!该分享已经审核通过或者审核不通过!");
        }
//        审核资源,将状态设为PASS/REJECT
        share.setAuditStatus(auditDTO.getAuditStatusEnum().toString());
        this.shareMapper.updateByPrimaryKey(share);
//        添加积分
//       异步执行
        this.rocketMQTemplate.convertAndSend("add-bonus",
                UserAddBonusMsgDTO.builder()
                        .userId(id)
                        .bonus(50)
                        .build()

        );
//        userCenterFeignClient.addBonus(id,500);
        return share;

    }
}
