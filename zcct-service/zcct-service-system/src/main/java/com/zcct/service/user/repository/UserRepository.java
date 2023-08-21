package com.zcct.service.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcct.service.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Mapper
public interface UserRepository extends BaseMapper<User> {

}
