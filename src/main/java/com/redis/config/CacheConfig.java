package com.redis.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport{
	private String[] cacheNames = {"Eilyn","Leo"};
	
	  @Bean
	  public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory connectionFactory) {
	    RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
	    redisTemplate.setConnectionFactory(connectionFactory);
	    return redisTemplate;
	  }

	  @Bean
	  public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
	    RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
	    cacheManager.setDefaultExpiration(300);
	    cacheManager.setCacheNames(Arrays.asList(cacheNames));
	    return cacheManager;
	  }
}
