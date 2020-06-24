package com.cloud.contentcenter.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.alibaba.nacos.client.naming.utils.Chooser;
import com.alibaba.nacos.client.naming.utils.Pair;
import com.alibaba.nacos.client.utils.LogUtils;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 王峥
 * @date 2020/6/24 9:15 下午
 */
@Slf4j
public class NacosSameClusterWeightedRule  extends AbstractLoadBalancerRule {
    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        try {
//        得到集群名字
            String clusterName = nacosDiscoveryProperties.getClusterName();
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            String name = loadBalancer.getName();
//        拿到服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
//        1.找到指定所有服务的所有实例 A
            List<Instance> instances = namingService.selectInstances(name, true);
//        2.过滤出相同集群下的所有实例 B
            List<Instance> sameClusterInstances = instances.stream()
                    .filter(instance -> Objects.equals(instance.getClusterName(), clusterName))
                    .collect(Collectors.toList());
//        3.如果B是空就用 A
            List<Instance> instancesToBeChose = new ArrayList<>();
            if (CollectionUtils.isEmpty(sameClusterInstances)) {
                instancesToBeChose = instances;
                log.warn("发生跨集群的调用: name= {} , clusterName = {} , instances = {}",
                        name,
                        clusterName,
                        instances
                );


            } else {
                instancesToBeChose = sameClusterInstances;
            }
//        4.基于权重的负载均衡算法,返回一个实例
            Instance instance = ExtendBalancer.getHostByRandomWeight2(instancesToBeChose);
            log.info("选择的实例是 port ={} , instance = {}", instance.getPort(), instance);
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("发生异常了", e);
            return null;
        }
    }

    static class ExtendBalancer extends Balancer {
        public static Instance getHostByRandomWeight2(List<Instance> hosts) {
            return getHostByRandomWeight(hosts);
        }
    }
}
