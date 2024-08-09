package com.zcct.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcct.service.user.api.dto.LogDto;
import com.zcct.service.user.domain.Log;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 13:52
 * @description:
 */
public interface LogService extends IService<Log> {

    Integer insertOperlog(LogDto operLog);
}
