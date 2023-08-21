package com.zcct.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcct.service.user.api.dto.LogDto;
import com.zcct.service.user.domain.Log;
import com.zcct.service.user.domain.mapper.LogMapper;
import com.zcct.service.user.repository.LogRepository;
import com.zcct.service.user.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 13:56
 * @description:
 */
@Service
@RequiredArgsConstructor
public class LogServiceImpl extends ServiceImpl<LogRepository, Log> implements LogService {

    private final LogMapper logMapper;

    @Override
    public Integer insertOperlog(LogDto operLog) {
        return this.getBaseMapper().insert(logMapper.toEntity(operLog));
    }
}
