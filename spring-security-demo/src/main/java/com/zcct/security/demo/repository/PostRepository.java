package com.zcct.security.demo.repository;

import com.zcct.security.demo.domain.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Mapper
public interface PostRepository extends BaseMapper<Post> {

}
