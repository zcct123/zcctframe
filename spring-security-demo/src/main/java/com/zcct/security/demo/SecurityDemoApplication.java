package com.zcct.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/29 19:14
 */

@SpringBootApplication
public class SecurityDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SecurityDemoApplication.class, args);

    }
}
