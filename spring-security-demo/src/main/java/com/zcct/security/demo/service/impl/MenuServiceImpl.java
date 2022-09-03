package com.zcct.security.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcct.security.demo.domain.Menu;
import com.zcct.security.demo.repository.MenuRepository;
import com.zcct.security.demo.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcct.security.demo.util.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-31
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuRepository, Menu> implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public Set<Menu> findByRoleIds(Set<Long> roleIds) {
        ValidateUtils.isNull(roleIds,"role");
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.in("sr.role_id",roleIds).eq("sr.is_deleted",0);
        return  menuRepository.findByRoleIds(wrapper);

    }
}
