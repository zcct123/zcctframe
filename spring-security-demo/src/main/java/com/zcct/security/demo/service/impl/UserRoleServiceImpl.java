package com.zcct.security.demo.service.impl;

import com.zcct.security.demo.domain.UserRole;
import com.zcct.security.demo.repository.UserRoleRepository;
import com.zcct.security.demo.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleRepository, UserRole> implements UserRoleService {

}
