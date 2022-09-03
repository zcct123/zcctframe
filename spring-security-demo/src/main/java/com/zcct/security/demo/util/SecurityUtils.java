package com.zcct.security.demo.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.zcct.security.demo.exception.BadRequestException;
import com.zcct.security.demo.security.entity.JwtUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zcct
 * @version 1.0
 * @description: 获取当前用户信息工具类
 * @date 2022/9/2 20:53
 */
public class SecurityUtils {

    /**
     * 获取当前登录用户
     *   建议 保存在
     * @return
     */
    public static JwtUser getCurrentUser() {
        UserDetailsService userDetailsService = SpringUtil.getBean(UserDetailsService.class);
        return (JwtUser)userDetailsService.loadUserByUsername(getCurrentUsername());
    }

    /**
     * 获取当前登录用户名
     * @return
     */
    public static String getCurrentUsername() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new BadRequestException(HttpStatus.FORBIDDEN,"当前登录状态过期");
        }
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
        throw new BadRequestException(HttpStatus.FORBIDDEN,"找不到当前登录的信息");
    }

    /**
     * 检查角色权限
     * @param rules
     */
    public static void checkRules(String[] rules) {
        Set<String> ruleKeys = SecurityUtils.getCurrentUser().getRuleKeys();
        boolean hasAuthority = ruleKeys.contains("admin") || Arrays.stream(rules).anyMatch(ruleKeys::contains);
        if(!hasAuthority) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"没有权限");
        }
    }

    /**
     * 检查是否登录
     */
    public static void checkLogin() {
        getCurrentUsername();
    }

    /**
     * 检查权限
     * @param permissions
     */
    public static void checkPermissions(String[] permissions) {
        // 获取所有权限
        List<String> allPermissions = SecurityUtils.getCurrentUser().getAuthorities().
                stream().map(GrantedAuthority::getAuthority).
                collect(Collectors.toList());
        boolean hasAuthority = allPermissions.contains("admin") || Arrays.stream(permissions).anyMatch(allPermissions::contains);
        if(!hasAuthority) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"没有权限");
        }
    }

    public static void checkAnonymous() {
        UserDetails userDetails = null;
        try{
            userDetails = getCurrentUser();
        }catch (Exception e){

        }
        if(ObjectUtil.isNotEmpty(userDetails)) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"不允许访问");
        }
    }
}
