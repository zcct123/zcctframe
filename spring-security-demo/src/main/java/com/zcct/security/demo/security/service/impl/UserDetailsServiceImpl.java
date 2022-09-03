package com.zcct.security.demo.security.service.impl;

import com.zcct.security.demo.domain.User;
import com.zcct.security.demo.exception.BadRequestException;
import com.zcct.security.demo.security.entity.JwtUser;
import com.zcct.security.demo.service.RoleService;
import com.zcct.security.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 19:20
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new BadRequestException("账号不存在");
        }

        if(user.getStatus() == 1) {
            throw new BadRequestException("账号已停用");
        }
        List<GrantedAuthority> authorities = roleService.getGrantedAuthorities(user);
        Set<String> roleKeys = roleService.getRoleKeys(user);
        return new JwtUser(user,roleKeys,authorities);
    }

}
