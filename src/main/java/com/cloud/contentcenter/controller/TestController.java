package com.cloud.contentcenter.controller;

import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.TestBaiduFeifnClient;
import com.cloud.contentcenter.feignclient.TestUserCenterFeigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王峥
 * @date 2020/6/23 10:27 下午
 */



@RestController
public class TestController {
    @Resource
    TestBaiduFeifnClient testBaiduFeifnClient;
    @Resource
    TestUserCenterFeigin testUserCenterFeigin;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("test2")
    public List<ServiceInstance> getInstances() {

        return discoveryClient.getInstances("user-center");
    }
    @GetMapping("test3")
    public List<String> getSeivices() {
        return discoveryClient.getServices();
    }
    @GetMapping("test-get")
    public UserDTO query(UserDTO userDTO) {
        return testUserCenterFeigin.query(userDTO);
    }
    @GetMapping("baidu")
    public String baiduIndex() {
        return testBaiduFeifnClient.index();
    }
}
