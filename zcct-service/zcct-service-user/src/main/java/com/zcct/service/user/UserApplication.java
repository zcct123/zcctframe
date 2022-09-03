package com.zcct.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 21:39
 */
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(UserApplication.class, args);
    }
}
