package com.zcct.rocketmq.config;

import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2024/8/9 09:53
 * @description:
 */
@Configuration
@EnableAutoConfiguration(exclude = RocketMQAutoConfiguration.class)
public class RocketMqConfig {

}
