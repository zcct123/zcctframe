package com.zcct.security.demo.repository;

import com.zcct.security.demo.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Mapper
public interface RoleRepository extends BaseMapper<Role> {

    @Select(" SELECT sr.* FROM sys_role sr LEFT JOIN sys_user_role sur on sr.role_id = sur.role_id " +
            " left join sys_user su on sur.user_id = su.user_id " +
            " WHERE sr.is_deleted = 0 and sr.`status` = 0 and su.user_id = #{userId} ")
    Set<Role> selectRoleByUserId(Long userId);
}
