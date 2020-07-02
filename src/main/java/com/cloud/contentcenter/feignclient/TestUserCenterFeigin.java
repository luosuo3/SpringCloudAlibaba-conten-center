package com.cloud.contentcenter.feignclient;

import com.cloud.contentcenter.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-center")
public interface TestUserCenterFeigin {
    @GetMapping("/q")
    UserDTO query(@SpringQueryMap UserDTO userDTO);

}
