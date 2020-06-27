package com.cloud.contentcenter.sentinelTest;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 王峥
 * @date 2020/6/27 6:04 下午
 */
@Slf4j
public class TestControllerFallbackHandlerClass {
    //处理降级或者其他异常
    public static String fallback(String a, BlockException e) {
        log.warn("限流或者降级了 fallback", e);
        return "限流或者降级了 fallback";
    }
}
