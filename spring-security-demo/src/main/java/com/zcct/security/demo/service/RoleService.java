package com.zcct.security.demo.service;

import com.zcct.security.demo.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zcct.security.demo.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取用户权限信息
     * @param user
     * @return
     */
    List<GrantedAuthority> getGrantedAuthorities(User user);

    /**
     * 获取角色权限
     * @param user
     * @return
     */
    Set<String> getRoleKeys(User user);
}
