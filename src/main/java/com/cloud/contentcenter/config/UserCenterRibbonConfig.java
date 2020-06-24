package com.cloud.contentcenter.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbonconfig.RibbonConfig;

/**
 * @author 王峥
 * @date 2020/6/24 11:17 上午
 */
@Configuration
@RibbonClients( defaultConfiguration = RibbonConfig.class)
//@RibbonClient(name = "user-center", Configuration=RibbonConfig.class)
public class UserCenterRibbonConfig {

}
