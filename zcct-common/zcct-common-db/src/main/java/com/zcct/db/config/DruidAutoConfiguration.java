package com.zcct.db.config;


import com.zcct.db.DynamicDataSource;
import com.zcct.db.DynamicDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 赵冲
 * @description
 * @date 2023/3/1
 */
@Configuration
public class DruidAutoConfiguration {

    @Autowired
    DynamicDataSourceProvider dynamicDataSourceProvider;

    @Bean
    DynamicDataSource dynamicDataSource() {
        return new DynamicDataSource(dynamicDataSourceProvider);
    }
}
