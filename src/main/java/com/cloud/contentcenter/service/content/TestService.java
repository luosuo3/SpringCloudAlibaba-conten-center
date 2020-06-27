package com.cloud.contentcenter.service.content;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 王峥
 * @date 2020/6/27 10:28 上午
 */
@Slf4j
@Service
public class TestService {
    @SentinelResource("commen")
    public String commen() {
        log.info("commen.......");
        return "commen";
    }
}
