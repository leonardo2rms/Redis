package com.redis.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class AppSesionConfig {
	
	List<String> clusterNodes = Arrays.asList("127.0.0.1:6379");
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory jedis = new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
//		JedisConnectionFactory jedis = new JedisConnectionFactory();
		// jedis.setHostName("redis-leonardo-azure.redis.cache.windows.net");
		// jedis.setPassword("f8hYW/u5j9wqowrdVA9u2YSbWgLOFKJ5mZ18uAQGwac=");
		return jedis;
	}

	// @Bean
	// public static ConfigureRedisAction configureRedisAction() {
	// return ConfigureRedisAction.NO_OP;
	// }
	// @Bean
	// public CookieSerializer cookieSerializer() {
	// DefaultCookieSerializer serializer = new DefaultCookieSerializer();
	// serializer.setCookieName("ACM1pt");
	// serializer.setCookiePath("/");
	// serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
	// return serializer;
	// }
	//
	// @Bean
	// public LettuceConnectionFactory connectionFactory() {
	// return new LettuceConnectionFactory();
	// }
}
