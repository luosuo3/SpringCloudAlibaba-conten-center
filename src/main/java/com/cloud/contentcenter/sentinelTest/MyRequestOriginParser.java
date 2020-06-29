package com.cloud.contentcenter.sentinelTest;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王峥
 * @date 2020/6/28 10:38 下午
 */
@Component
@Slf4j
public class MyRequestOriginParser implements RequestOriginParser {
    private static final String ALLOW = "origin";
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
       /* String allow = httpServletRequest.getParameter(ALLOW);
        log.warn("ALLOW={}",allow);
        if (!StringUtils.isNotBlank(allow)) {
            throw new IllegalArgumentException("allow is must be specified!");
        }*/

        return null;
//        return allow;
    }
}
