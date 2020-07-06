package com.cloud.contentcenter.feignclient;

import com.cloud.contentcenter.dto.UserAddBonusDTO;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.fallbackfactory.UserCenterFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//fallbackFactory可以拿到异常.比fallback功能更强大一些
//@FeignClient(name = "user-center",fallback = UserCenterFeignClientFallback.class)
@FeignClient(name = "user-center", fallbackFactory = UserCenterFeignClientFallbackFactory.class)
//@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
//@FeignClient(name = "user-center")
public interface UserCenterFeignClient {

    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id);

    @PutMapping("/users/add-bonus")
    UserDTO addBonus(@RequestBody UserAddBonusDTO userAddBonusDTO);

}
