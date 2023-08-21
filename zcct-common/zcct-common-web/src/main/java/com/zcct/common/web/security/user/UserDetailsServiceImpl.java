package com.zcct.common.web.security.user;

import com.zcct.service.user.api.feign.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 09:37
 * @description:
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is not null");
        }

        return  null;

    }
}
