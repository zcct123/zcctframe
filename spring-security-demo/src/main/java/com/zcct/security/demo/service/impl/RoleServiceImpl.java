package com.zcct.security.demo.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zcct.security.demo.domain.Menu;
import com.zcct.security.demo.domain.Role;
import com.zcct.security.demo.domain.User;
import com.zcct.security.demo.repository.MenuRepository;
import com.zcct.security.demo.repository.RoleRepository;
import com.zcct.security.demo.service.MenuService;
import com.zcct.security.demo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
@CacheConfig(cacheNames = "role")
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleRepository, Role> implements RoleService {

    private final RoleRepository roleRepository;
    private final MenuService menuService;

    @Override
    @Cacheable(key = "'auth:' + #p0.userId")
    public List<GrantedAuthority> getGrantedAuthorities(User user) {

        Set<String> permissions = new HashSet<>();

        if(user.getUserType() == 0) {
            permissions.add("admin");
        }else {
            Set<Role> roles = roleRepository.selectRoleByUserId(user.getUserId());
            if(CollectionUtil.isNotEmpty(roles)) {
                Set<Menu> menu = menuService.findByRoleIds(roles.stream().map(Role::getRoleId).collect(Collectors.toSet()));
                permissions = menu.stream().map(Menu::getPermission).collect(Collectors.toSet());
            }
        }
        return permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getRoleKeys(User user) {
        Set<Role> roles = roleRepository.selectRoleByUserId(user.getUserId());
        return roles.stream().map(Role::getRoleKey).collect(Collectors.toSet());
    }
}
