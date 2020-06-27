package com.cloud.contentcenter.feignclient.fallback;

import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.UserCenterFeignClient;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

/**
 * @author 王峥
 * @date 2020/6/27 9:30 下午
 */
@Component
public class UserCenterFeignClientFallback implements UserCenterFeignClient {
    @Override
    public UserDTO findById(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setWxNickname("一个测试用户");
        return userDTO;
    }
}
