package com.springfive.trackedhashtagservice.domain.repository

import org.springframework.stereotype.Service
import org.springframework.data.redis.core.ReactiveRedisTemplate
import com.springfive.trackedhashtagservice.domain.models.TrackedHashTag
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux

@Service
class TrackedHashTagRepository (private val redisTemplate: ReactiveRedisTemplate<String, String>) {
	
	fun save(trackedHashTag: TrackedHashTag): Mono<TrackedHashTag> {
		return this.redisTemplate
				   .opsForSet()
				   .add("hash-tags", "${trackedHashTag.hashTag}:${trackedHashTag.queue}")
				   .flatMap({Mono.just(trackedHashTag)})
	}
	
	fun findAll(): Flux<TrackedHashTag> {
		return this.redisTemplate
				   .opsForSet()
				   .members("hashtags")
				   .flatMap { el ->
					   val data = el.split(":")
					   Flux.just(TrackedHashTag(hashTag = data[0], queue = data[1]))
				   }
	}
	
}