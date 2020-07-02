package com.cloud.contentcenter.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingMaintainService;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author 王峥
 * @date 2020/6/24 8:16 下午
 */
@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {
    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
//             读取配置文件并且初始化
    }

    @Override
    public Server choose(Object o) {
        try {
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            String name = loadBalancer.getName();
//        拿到服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
//        Nacos client 自动通过基于权重的负载均衡算法,给我们一个实例.
            Instance instance = namingService.selectOneHealthyInstance(name);
            log.info("选择的实例是 port={},instance={}", instance.getPort(), instance);
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }
    }
}
