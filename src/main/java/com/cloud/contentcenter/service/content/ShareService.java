package com.cloud.contentcenter.service.content;

import com.cloud.contentcenter.dto.ShareDTO;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.mapper.ShareMapper;
import com.cloud.contentcenter.model.Share;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

    public ShareDTO findByid(Integer id) {

        Share share = this.shareMapper.selectByPrimaryKey(id);
        Integer userId = share.getUserId();
//        默认懒加载首次请求后才创建访问client导致首次加载过慢
        UserDTO userDTO = restTemplate.getForObject(
                "http://user-center/users/{userId}",
                UserDTO.class,
                userId
        );
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

}
