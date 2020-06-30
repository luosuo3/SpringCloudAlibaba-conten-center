package com.cloud.contentcenter;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.cloud.contentcenter.config.GlobalCenterFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Source;

//@EnableFeignClients(defaultConfiguration = GlobalCenterFeignConfiguration.class)
@EnableFeignClients
@MapperScan("com.cloud.contentcenter.mapper")
@SpringBootApplication
@EnableBinding(Source.class)
public class ContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }

    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
