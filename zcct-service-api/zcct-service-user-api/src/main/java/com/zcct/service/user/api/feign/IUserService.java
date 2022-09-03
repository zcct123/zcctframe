package com.zcct.service.user.api.feign;

import com.zcct.common.base.constant.ServiceConstants;
import com.zcct.service.user.api.feign.factory.IUserServicetFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zcct
 * @version 1.0
 * @description: Feign接口类
 * @date 2022/8/28 11:19
 */
@FeignClient(value = ServiceConstants.ZCCT_SERVICE_USER,fallbackFactory = IUserServicetFallback.class
)
public interface IUserService {


}
