package com.cloud.contentcenter.feignclient;

import com.cloud.contentcenter.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-center")
public interface UserCenterFeignClient {

    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id);
}
