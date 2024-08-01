package com.zcct.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 17:53
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZcctGatewatAppliction {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ZcctGatewatAppliction.class, args);
    }
}
