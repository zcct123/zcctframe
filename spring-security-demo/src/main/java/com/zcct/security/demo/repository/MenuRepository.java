package com.zcct.security.demo.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zcct.security.demo.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.management.Query;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-31
 */
@Mapper
public interface MenuRepository extends BaseMapper<Menu> {
    @Select(" SELECT sm.* FROM sys_menu sm LEFT JOIN sys_role_menu srm using (menu_id) " +
            " left join sys_role sr on srm.role_id = sr.role_id ${ew.customSqlSegment}")
    Set<Menu> findByRoleIds(@Param(Constants.WRAPPER) QueryWrapper<Menu> queryWrapper);
}
