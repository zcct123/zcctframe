package com.zcct.security.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcct.security.demo.domain.User;
import com.zcct.security.demo.repository.UserRepository;
import com.zcct.security.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {

    private final UserRepository userRepository;
    @Override
    public User queryById(Long id) {
        return userRepository.selectById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.selectOne(new QueryWrapper<User>().eq("user_name", username));
    }
}
