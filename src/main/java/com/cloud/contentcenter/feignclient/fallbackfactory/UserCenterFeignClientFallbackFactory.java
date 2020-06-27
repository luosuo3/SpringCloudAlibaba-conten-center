package com.cloud.contentcenter.feignclient.fallbackfactory;

import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.UserCenterFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 王峥
 * @date 2020/6/27 9:38 下午
 */
@Component
@Slf4j
public class UserCenterFeignClientFallbackFactory implements FallbackFactory<UserCenterFeignClient> {
    @Override
    public UserCenterFeignClient create(Throwable throwable) {
        return new UserCenterFeignClient() {
            @Override
            public UserDTO findById(Integer id) {
                log.warn("远程调用被限流或者降级了!",throwable);
                UserDTO userDTO = new UserDTO();
                userDTO.setWxNickname("一个测试用户");
                return userDTO;
            }
        };
    }
}
