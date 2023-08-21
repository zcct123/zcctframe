package com.zcct.service.user.service.impl;

import com.zcct.service.user.domain.Role;
import com.zcct.service.user.repository.RoleRepository;
import com.zcct.service.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleRepository, Role> implements RoleService {

}
