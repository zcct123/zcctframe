package com.zcct.common.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 09:27
 * @description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {


//    @Bean
//    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .exceptionHandling()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests((authorize) -> authorize
//                        .antMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
//                        .antMatchers("/api/v1/auth/**").permitAll()
//                        .antMatchers("/v2/api-docs/**").permitAll()
//                        .antMatchers("/swagger-ui/**").permitAll()
//                        .antMatchers("/swagger-resources/**").permitAll()
//                        .antMatchers("/swagger-ui.html").permitAll()
//                        .antMatchers("/webjars/**").permitAll()
//                        .anyRequest()
//                        .authenticated()
//                );
//        return http.build();
//    }

}
