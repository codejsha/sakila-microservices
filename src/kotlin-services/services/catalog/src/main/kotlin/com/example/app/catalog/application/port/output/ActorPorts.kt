package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.record.ActorRecord
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ActorManagementPort {
    fun addActor(actorAddRequestDto: ActorAddRequestDto): Mono<ActorAggregate>
    fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto): Mono<ActorAggregate>
    fun deleteActor(id: Int): Mono<Boolean>
}

interface ActorSearchPort {
    fun findById(id: Int): Mono<ActorRecord>
    fun findAll(): Flux<ActorRecord>
}
