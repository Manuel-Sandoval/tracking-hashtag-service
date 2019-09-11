package com.springfive.trackedhashtagservice.domain.resource

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import com.springfive.trackedhashtagservice.domain.service.TrackedHashTagService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.springfive.trackedhashtagservice.domain.models.TrackedHashTag
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/tracked-hash-tag")
class TrackedHashTagResource (private val service:TrackedHashTagService) {
	
	@GetMapping
	fun all() = this.service.all()
	
	@PostMapping
	fun save(@RequestBody hashTag: TrackedHashTag): Mono<TrackedHashTag> {
		return this.service.save(hashTag)
	}
}