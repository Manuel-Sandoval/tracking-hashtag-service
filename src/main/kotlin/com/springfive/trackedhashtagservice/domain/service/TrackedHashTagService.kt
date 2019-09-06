package com.springfive.trackedhashtagservice.domain.service

import org.springframework.stereotype.Service
import com.springfive.trackedhashtagservice.domain.repository.TrackedHashTagRepository
import com.springfive.trackedhashtagservice.domain.models.TrackedHashTag

@Service
class TrackedHashTagService (private val repository: TrackedHashTagRepository) {
	
	fun save(hashTag: TrackedHashTag) = this.repository.save(hashTag);
	
	fun all() = this.repository.findAll();
	
}