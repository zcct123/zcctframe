package com.zcct.common.redis.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * @author zcct
 * @version 1.0
 * @description: 失败处理
 * @date 2022/8/28 12:02
 */
@Slf4j
public class RedisCacheErrorHandler implements CacheErrorHandler {
    
    @Override
    public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
        log.error("Redis handleCacheGetError：key -> [{}]", key, e);
    }

    @Override
    public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
        log.error("Redis handleCachePutError：key -> [{}]；value -> [{}]", key, value, e);
    }

    @Override
    public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
        log.error("Redis handleCacheEvictError：key -> [{}]", key, e);
    }

    @Override
    public void handleCacheClearError(RuntimeException e, Cache cache) {
        log.error("Redis handleCacheClearError：", e);
    }
}
