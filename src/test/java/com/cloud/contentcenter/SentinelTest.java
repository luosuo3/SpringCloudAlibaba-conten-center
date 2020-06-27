package com.cloud.contentcenter;

import org.springframework.web.client.RestTemplate;

/**
 * @author 王峥
 * @date 2020/6/27 10:08 上午
 */
public class SentinelTest {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10000; i++) {
            String forObject = restTemplate.getForObject("http://localhost:8090/actuator/sentinel", String.class);
            Thread.sleep(5);

        }
    }
}
