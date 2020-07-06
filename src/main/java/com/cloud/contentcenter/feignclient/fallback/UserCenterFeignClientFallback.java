package com.cloud.contentcenter.feignclient.fallback;

import com.cloud.contentcenter.dto.UserAddBonusDTO;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.UserCenterFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author 王峥
 * @date 2020/6/27 9:30 下午
 */
@Component
public class UserCenterFeignClientFallback implements UserCenterFeignClient {
    @Override
    public UserDTO addBonus(UserAddBonusDTO userAddBonusDTO) {
        return null;
    }

    @Override
    public UserDTO findById(Integer id) {
       return null;
    }
}
