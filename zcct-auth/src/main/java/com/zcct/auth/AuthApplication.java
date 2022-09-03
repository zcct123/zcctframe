package com.zcct.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/28 15:49
 */
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AuthApplication.class, args);
    }
}
