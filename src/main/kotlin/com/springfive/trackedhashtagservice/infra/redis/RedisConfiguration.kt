package com.springfive.trackedhashtagservice.infra.redis

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate

@Configuration
open class RedisConfiguration {
	
	@Bean
	open fun reactiveRedisTemplate (connectionFactory: ReactiveRedisConnectionFactory) : ReactiveRedisTemplate<String, String> {
		return ReactiveRedisTemplate(connectionFactory, RedisSerializationContext.string())
	}
	
}