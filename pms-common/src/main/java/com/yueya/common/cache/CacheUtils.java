package com.yueya.common.cache;

import com.yueya.common.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;


/**
 * Cache工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class CacheUtils {
	
	private static Logger logger = LoggerFactory.getLogger(CacheUtils.class);
	private static CacheManager cacheManager = SpringContextUtil.getBean(CacheManager.class);
	

	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, String key) {
		return getCache(cacheName).get(getKey(key));
	}
	
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static Object get(String cacheName, String key, Object defaultValue) {
		Object value = get(cacheName, getKey(key));
		return value != null ? value : defaultValue;
	}
	
	/**
	 * 写入缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, String key, Object value) {
		getCache(cacheName).put(getKey(key), value);
	}

	/**
	 * 从缓存中移除
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, String key) {
		getCache(cacheName).evict(getKey(key));
	}

	/**
	 * 从缓存中移除所有
	 * @param cacheName
	 */
	public static void removeAll(String cacheName) {
		Cache cache = getCache(cacheName);
		cache.clear();
	}
	
	/**
	 * 获取缓存键名，多数据源下增加数据源名称前缀
	 * @param key
	 * @return
	 */
	private static String getKey(String key){
		return key;
	}
	
	/**
	 * 获得一个Cache，没有则显示日志。
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName){
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null){
			throw new RuntimeException("当前系统中没有定义“"+cacheName+"”这个缓存。");
		}
		return cache;
	}

}
