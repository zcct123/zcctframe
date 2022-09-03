//package com.zcct.auth.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * @author zcct
// * @version 1.0
// * @description: TODO
// * @date 2022/8/28 15:15
// */
//@Configuration
//@EnableAuthorizationServer
//@RequiredArgsConstructor
//public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
//
//    // 授权码服务
//    @Autowired
//    private AuthorizationCodeServices authorizationCodeServices;
//    // 访问令牌服务
//    @Autowired
//    private AuthorizationServerTokenServices tokenServices;
//    // 访问令牌管理服务
//    @Autowired
//    private TokenStore tokenStore;
//    // 客户端服务，由于我们使用了内存模式，会自动创建一个默认的客户端服务
//    @Autowired
//    private ClientDetailsService clientDetailsService;
//
//    /**
//     * 配置客户端的详情，提供客户端的信息
//     *
//     * 客户端通过访问如下地址来获取授权码
//     * /oauth/authorize?client_id=iSchool&response_type=code&scope=all&redirect_uri=http://localhost:8080
//     * 客户端通过访问如下地址来获取访问token，访问token仅能使用一次
//     * /oauth/token?client_id=iSchool&client_secret=mysecret&grant_type=authorization_code&code=授权码&redirect_uri=http://localhost:8080
//     *
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                // 基于内存方式存储客户信息
//                .inMemory()
//                // client_id，分配给客户端的标识
//                .withClient("iSchool")
//                // secret密钥，加密存储
//                .secret(new BCryptPasswordEncoder().encode("mysecret"))
//                // 当前仅开启授权码模式，refresh_token表示开启刷新令牌
//                .authorizedGrantTypes("authorization_code","refresh_token")
//                // 允许授权的范围，默认为空表示允许访问全部范围，这个在资源服务器那里用的到
//                .scopes("all")
//                // 资源服务器的ID配置，可以是多个，这个在资源服务器那里用的到
//                .resourceIds("user")
//                // 设置该client_id的主体所拥有的权限信息，在客户端模式下生效，在资源服务器那里用的到
//                .authorities("user:query")
//                // 需要用户手动授权，即会弹出界面需要用户手动点击授权
//                .autoApprove(false)
//                // 重定向地址，这里是第三方客户端的地址，用来接收授权服务器返回的授权码
//                .redirectUris("http://localhost:8080");
//        // 可以通过and()再添加其它的客户端信息，这里省略
//    }
//
//    /**
//     * 配置令牌的访问端点和令牌管理服务
//     * 默认的访问端点如下：
//     * /oauth/authorize：授权端点，获取授权码
//     * /oauth/token：令牌端点，获取访问令牌
//     * /oauth/confirm_access：用户确认授权提交端点
//     * /oauth/error：授权服务错误信息端点
//     * /oauth/check_token：提供给资源服务访问的令牌验证端点
//     * /oauth/token_key：提供公有密匙的端点，JWT模式使用
//     *
//     * @param endpoints
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                // 指定授权码管理策略
//                .authorizationCodeServices(authorizationCodeServices)
//                // 指定token管理策略，token会自己生成一个随机值
//                .tokenServices(tokenServices)
//                // 指定访问token的请求方法，实际应该使用POST方式，这里为了演示方便使用GET
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET);
//    }
//
//    /**
//     * 配置令牌访问端点的安全约束
//     *
//     * @param security
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                // 放开/oauth/check_token这个端点，供资源服务器调用来校验访问token的合法性
//                .checkTokenAccess("permitAll()")
//                // 开启表单认证
//                .allowFormAuthenticationForClients();
//    }
//
//    /**
//     * 配置授权码模式下授权码的存取方式，此时采用内存模式
//     * @return
//     */
//    @Bean
//    public AuthorizationCodeServices authorizationCodeServices() {
//        return new InMemoryAuthorizationCodeServices();
//    }
//
//    /**
//     * 配置令牌管理服务
//     * @return
//     */
//    @Bean
//    public AuthorizationServerTokenServices tokenServices() {
//        DefaultTokenServices services = new DefaultTokenServices();
//        // 配置客户端详情服务，获取客户端的信息
//        services.setClientDetailsService(clientDetailsService);
//        // 支持刷新令牌
//        services.setSupportRefreshToken(true);
//        // 配置令牌的存储方式，此时采用内存方式存储
//        services.setTokenStore(tokenStore);
//        // 访问令牌有效时间2小时
//        services.setAccessTokenValiditySeconds(7200);
//        // 刷新令牌的有效时间3天
//        services.setRefreshTokenValiditySeconds(259200);
//        return services;
//    }
//
//}
