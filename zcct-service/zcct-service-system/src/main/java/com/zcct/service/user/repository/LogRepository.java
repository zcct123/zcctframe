package com.zcct.service.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcct.service.user.domain.Dept;
import com.zcct.service.user.domain.Log;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 13:54
 * @description:
 */
@Mapper
public interface LogRepository extends BaseMapper<Log> {
}
