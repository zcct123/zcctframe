package com.zcct.service.user.repository;

import com.zcct.service.user.domain.UserPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与岗位关联表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Mapper
public interface UserPostRepository extends BaseMapper<UserPost> {

}
