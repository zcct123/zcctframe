package com.zcct.service.user.service.impl;

import com.zcct.service.user.domain.User;
import com.zcct.service.user.repository.UserRepository;
import com.zcct.service.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {

}
