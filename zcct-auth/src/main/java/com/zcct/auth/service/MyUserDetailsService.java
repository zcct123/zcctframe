package com.zcct.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/28 16:56
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 为了演示方便，使用内存定义用户的真实账密及其访问权限
        return User
                .withUsername("zcct")
                .password(passwordEncoder.encode("mm123"))
                // 设置当前用户可以拥有的权限信息，授权码模式下，用户输入账密后就拥有该权限
                .authorities("user:query")
                .build();
    }
}
