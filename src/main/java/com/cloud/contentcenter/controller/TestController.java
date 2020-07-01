package com.cloud.contentcenter.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.cloud.contentcenter.dto.UserDTO;
import com.cloud.contentcenter.feignclient.TestBaiduFeifnClient;
import com.cloud.contentcenter.feignclient.TestUserCenterFeigin;
import com.cloud.contentcenter.sentinelTest.TestControllerBlockHandlerClass;
import com.cloud.contentcenter.sentinelTest.TestControllerFallbackHandlerClass;
import com.cloud.contentcenter.service.content.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王峥
 * @date 2020/6/23 10:27 下午
 */

@Slf4j
@RestController
public class TestController {
    @Resource
    RestTemplate restTemplate;
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

    @Resource
    private TestService testService;

    //测试簇点链路规则的方法
    @GetMapping("/a")
    public String testA() {
        testService.commen();
        return "test-a";
    }

    @GetMapping("/b")
    public String testB() {
        testService.commen();
        return "test-b";
    }

    @GetMapping("/test-hot")
    @SentinelResource("hot")
    public String testHot(
            @RequestParam(required = false) String a,
            @RequestParam(required = false) String b
    ) {

        return a + "" + b;
    }

    @GetMapping("/test-add-flow-rule")
    public String testAddFlowRule() {
        this.initFlowQpsRule();
        return "success";
    }

    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("/shares/1");
        // set limit qps to 20
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    @GetMapping("/test-sentinel-api")
    public String testSentinelApi(
            @RequestParam(required = false) String a
    ) {
        Entry entry = null;
        try {
//            定义一个被保护的资源名字是"test-sentinel-api"
            final String resourceName = "test-sentinel-api";
            ContextUtil.enter(resourceName, "test-wfw");
            entry = SphU.entry(resourceName);
            if (StringUtils.isNotBlank(a)) {
                throw new IllegalArgumentException("a不能为空");
            }
            return a;
//            如果资源被限流或者降级了就会抛异常
//            sentinel异常比例只统计了BlockException没有统计其他异常

        } catch (BlockException e) {
            log.warn("限流或者降级了", e);
            return "限流或者降级了";
        } catch (IllegalArgumentException e2) {
            Tracer.trace(e2);
            return "参数非法!";
        } finally {
            if (entry != null) {
                entry.exit();

            }
            ContextUtil.exit();

        }

    }

    //用@SentinelResource注解重构一下
    @GetMapping("/test-sentinel-resource")
    @SentinelResource(value = "test-sentinel-resource", blockHandler = "block", fallback = "fallback", fallbackClass = TestControllerFallbackHandlerClass.class, blockHandlerClass = TestControllerBlockHandlerClass.class)
    public String testSentinelResource(@RequestParam(required = false) String a) {
        if (!StringUtils.isNotBlank(a)) {
            throw new IllegalArgumentException("a can not be Blank .");
        }
        return a;

    }

    //    处理限流或者降级
    public static String block(String a, BlockException e) {
        log.warn("限流或者降级了 block", e);
        return "限流或者降级了 block";
    }

    //处理降级或者其他异常
    public static String fallback(String a, BlockException e) {
        log.warn("限流或者降级了 fallback", e);
        return "限流或者降级了 fallback";
    }

    @GetMapping("/test-rest-template-sentinel/{userId}")
    public UserDTO testRest(@PathVariable("userId") String userId) {
        UserDTO userDTO = restTemplate.getForObject(
                "http://user-center/users/{userId}",
                UserDTO.class,
                userId
        );
        return userDTO;
    }

    @Resource
    private Source source;

    @GetMapping("/test-stream")
    public String testStream() {
        this.source.output()
                .send(
                        MessageBuilder
                                .withPayload("测试消息体")
                                .build()
                );
        return "success";
    }


}
