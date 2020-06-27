package ribbonconfig;

/**
 * @author 王峥
 * @date 2020/6/24 11:19 上午
 */

import com.cloud.contentcenter.config.NacosSameClusterWeightedRule;
import com.netflix.loadbalancer.IRule;
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
