package com.zcct.service.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcct.service.user.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Mapper
public interface DeptRepository extends BaseMapper<Dept> {

}
