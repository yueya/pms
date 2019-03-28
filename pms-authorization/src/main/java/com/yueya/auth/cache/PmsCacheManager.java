package com.yueya.auth.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class PmsCacheManager implements CacheManager {
    private String CACHE_PREFIX="_shiro_cache_";
    private int EXPIRE_TIME = 30; // 单位：分钟
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new JedisCache(CACHE_PREFIX+s,redisTemplate,EXPIRE_TIME);
    }

}
