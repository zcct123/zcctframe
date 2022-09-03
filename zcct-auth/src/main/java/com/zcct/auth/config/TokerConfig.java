package com.zcct.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/28 15:32
 */
@Configuration
public class TokerConfig {

    /**
     * 令牌存储策略
     * @return
     */
    private static final String SIGNING_KEY = "auth123";

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(SIGNING_KEY);//对称秘钥，资源服务器使用该秘钥来验证
        return jwtAccessTokenConverter;
    }
}
