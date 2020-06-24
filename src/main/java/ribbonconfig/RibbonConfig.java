package ribbonconfig;

/**
 * @author 王峥
 * @date 2020/6/24 11:19 上午
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
