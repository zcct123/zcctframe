package com.zcct.service.user.api.feign;

import com.zcct.common.base.constant.ServiceConstants;
import com.zcct.common.domain.R;
import com.zcct.service.user.api.dto.LogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = ServiceConstants.ZCCT_SERVICE_USER)
public interface ILogService {
    @PostMapping("/log")
    public R<Integer> saveLog(@RequestBody LogDto logDto) throws Exception;
}
