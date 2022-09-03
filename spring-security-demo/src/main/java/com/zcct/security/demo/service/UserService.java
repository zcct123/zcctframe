package com.zcct.security.demo.service;

import com.zcct.common.base.domain.R;
import com.zcct.security.demo.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
public interface UserService extends IService<User> {

    User queryById(Long id);

    /**
     * 根据名称查询用户信息
     * @param username
     * @return
     */
    User findByUserName(String username);
}
