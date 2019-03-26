package com.yueya.auth.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.Collection;
import java.util.Set;

public class JedisCache<K, V> implements Cache<K, V> {

    private RedisTemplate<String, Object> redisTemplate;
    private int expireTime ;
    private String name;
    public JedisCache(String name,RedisTemplate<String, Object> redisTemplate,int expireTime) {
        this.redisTemplate = redisTemplate;
        this.expireTime = expireTime;
        this.name = name;
    }



    @Override
    public V get(K key) throws CacheException {
        if (key == null){
            return null;
        }
        return redisTemplate.<K,V>opsForHash().get(name,key);
    }

    @Override
    public V put(K key, V object) throws CacheException {
        if (key == null){
            return null;
        }
        redisTemplate.<K,V>opsForHash().put(name,key,object);
        return object;
    }

    @Override
    public V remove(K key) throws CacheException {
        V value = redisTemplate.<K,V>opsForHash().get(name,key);
        redisTemplate.<K,V>opsForHash().delete(name,key);
        return value;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(name);
    }

    @Override
    public int size() {
        return redisTemplate.<K,V>opsForHash().size(name).intValue();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.<K,V>opsForHash().keys(name);
    }

    @Override
    public Collection<V> values() {
        return redisTemplate.<K,V>opsForHash().values(name);
    }
}
