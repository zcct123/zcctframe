package com.zcct.security.demo.security.service;

import com.zcct.security.demo.domain.User;
import com.zcct.security.demo.security.entity.LoginUser;
import com.zcct.security.demo.security.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

/**
 * @author zcct
 * @version 1.0
 * @description: 用户登录服务
 * @date 2022/8/31 21:47
 */
public interface UserLoginService {

    /**
     * 用户登录
     * @param loginUser
     * @return
     */
    Map<String, Object> login(LoginUser loginUser);

    UserInfo getInfo();

    void logout();
}
