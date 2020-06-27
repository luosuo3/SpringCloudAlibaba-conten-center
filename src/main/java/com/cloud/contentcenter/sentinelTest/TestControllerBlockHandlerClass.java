package com.cloud.contentcenter.sentinelTest;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 王峥
 * @date 2020/6/27 6:00 下午
 */
@Slf4j
public class TestControllerBlockHandlerClass {
    //    处理限流或者降级
    public static String block(String a, BlockException e) {
        log.warn("限流或者降级了 block", e);
        return "限流或者降级了 block";
    }
}
