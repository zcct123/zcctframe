package com.zcct.service.user.service.impl;

import com.zcct.service.user.domain.UserRole;
import com.zcct.service.user.repository.UserRoleRepository;
import com.zcct.service.user.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleRepository, UserRole> implements UserRoleService {

}
