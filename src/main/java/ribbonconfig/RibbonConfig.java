package ribbonconfig;

/**
 * @author 王峥
 * @date 2020/6/24 11:19 上午
 */

import com.cloud.contentcenter.config.NacosSameClusterWeightedRule;
import com.cloud.contentcenter.config.NacosWeightedRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new NacosSameClusterWeightedRule();
//        return new NacosWeightedRule();
//        return new RandomRule();
    }
    /*
    @Bean
    public IPing iPing() {
        return new PingUrl();
    }*/

}
