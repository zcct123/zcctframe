package com.zcct.security.demo.service;

import com.zcct.security.demo.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author zcct
 * @since 2022-08-31
 */
public interface MenuService extends IService<Menu> {

    /**
     * 根据角色查询所有菜单
     * @param roleIds
     * @return
     */
    Set<Menu> findByRoleIds(Set<Long> roleIds);
}
