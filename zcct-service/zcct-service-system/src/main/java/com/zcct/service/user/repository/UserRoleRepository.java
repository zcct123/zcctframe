package com.zcct.service.user.repository;

import com.zcct.service.user.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Mapper
public interface UserRoleRepository extends BaseMapper<UserRole> {

}
