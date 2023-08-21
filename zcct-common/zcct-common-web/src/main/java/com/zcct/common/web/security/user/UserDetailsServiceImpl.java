package com.zcct.common.web.security.user;

import com.zcct.service.user.api.feign.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 09:37
 * @description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is not null");
        }

        return  null;

    }
}
