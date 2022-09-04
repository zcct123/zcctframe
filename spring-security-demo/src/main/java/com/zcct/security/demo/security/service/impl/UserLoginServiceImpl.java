package com.zcct.security.demo.security.service.impl;


import com.alibaba.fastjson.JSON;
import com.zcct.common.redis.service.RedisUtil;
import com.zcct.security.demo.domain.Role;
import com.zcct.security.demo.domain.User;
import com.zcct.security.demo.repository.RoleRepository;
import com.zcct.security.demo.security.JwtTokenProvider;
import com.zcct.security.demo.security.entity.JwtUser;
import com.zcct.security.demo.security.entity.LoginUser;
import com.zcct.security.demo.security.entity.UserInfo;
import com.zcct.security.demo.security.service.UserLoginService;
import com.zcct.security.demo.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 21:48
 */

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {

    private final RedisUtil redisUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RoleRepository roleRepository;
    @Override
    public Map<String, Object> login(LoginUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        // 生成一个 AuthenticationToken
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
        // 使用  authenticationManager 进行认证
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        JwtUser jwtUser = (JwtUser)authentication.getPrincipal();
        Long userId = jwtUser.getUser().getUserId();
        String jwtToken = jwtTokenProvider.createToken(String.valueOf(userId),jwtUser);

        Map<String, Object> authInfo = new HashMap<String, Object>(2) {{
            put("token", "Bearer " + jwtToken);
            put("user", userId);
        }};



        return authInfo;
    }

    @Override
    public UserInfo getInfo() {
        JwtUser currentUser = SecurityUtils.getCurrentUser();
        Set<Role> roles = roleRepository.selectRoleByUserId(currentUser.getUser().getUserId());
        return new UserInfo(roles , currentUser.getUsername(), currentUser.getUser().getAvatar());
    }

    @Override
    public void logout() {
        JwtUser currentUser = SecurityUtils.getCurrentUser();
        Long userId = currentUser.getUser().getUserId();
        redisUtil.del("login:"+userId);
    }
}
