package com.cloud.contentcenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

/**
 * Feign的配置类
 * 不加Configuration注解否则会引起父子上下文冲突导致全局Feign配置生效
 *
 * @author 王峥
 * @date 2020/6/26 5:38 下午
 */
public class GlobalCenterFeignConfiguration {
    @Bean
    public Logger.Level level() {
//        打印所有请求的细节日志
        return Logger.Level.FULL;
    }
}
