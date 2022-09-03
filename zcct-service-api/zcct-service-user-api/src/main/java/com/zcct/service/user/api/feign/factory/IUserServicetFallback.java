package com.zcct.service.user.api.feign.factory;

import com.zcct.service.user.api.feign.IUserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcct
 * @version 1.0
 * @description: 降级处理
 * @date 2022/8/28 11:27
 */
@Slf4j
public class IUserServicetFallback implements FallbackFactory<IUserService> {
    @Override
    public IUserService create(Throwable throwable) {
        log.error("用户信息服务调用失败 {}" + throwable.getMessage());
        return new IUserService() {
        };
    }
}
