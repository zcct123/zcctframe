package com.zcct.common.redis.configure;

import cn.hutool.core.util.StrUtil;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcct
 * @version 1.0
 * @description: 自定义缓存key生成策略
 *  DefaultKeyGenerator 最终返回的 缓存键值当参数列表的值相同时是一样的 这样就会造成获取到错误的缓存数据
 * @date 2022/8/28 12:04
 */
public class CacheKeyGenerator implements KeyGenerator {
    private static final String SP = ":";
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder key = new StringBuilder();

        Class<?> targetClassClass = target.getClass();
        key.append(targetClassClass.getPackage());
        key.append(SP);
        key.append(targetClassClass.getName());
        key.append(SP);
        key.append(method.getName());
        key.append(SP);
        if(params.length > 0){
            key.append(StrUtil.join(",",params));
        }
        return key.toString();
    }
}
