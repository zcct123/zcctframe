package com.zcct.service.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcct.service.user.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Mapper
public interface RoleRepository extends BaseMapper<Role> {

}
