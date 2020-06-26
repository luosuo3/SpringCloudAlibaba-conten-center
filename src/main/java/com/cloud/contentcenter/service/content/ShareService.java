package com.cloud.contentcenter.service.content;

import com.cloud.contentcenter.dto.ShareDTO;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.UserCenterFeignClient;
import com.cloud.contentcenter.mapper.ShareMapper;
import com.cloud.contentcenter.model.Share;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
    public ShareDTO findByid(Integer id) {

        Share share = this.shareMapper.selectByPrimaryKey(id);
        Integer userId = share.getUserId();
//        默认懒加载首次请求后才创建访问client导致首次加载过慢

        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        UserDTO userDTO = this.userCenterFeignClient.findById(userId);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

}
