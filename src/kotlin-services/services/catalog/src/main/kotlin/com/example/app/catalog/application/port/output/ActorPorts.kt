package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.entity.ActorAggregate
import reactor.core.publisher.Mono

interface AddActorPort {
    fun addActor(actorAddRequestDto: ActorAddRequestDto): Mono<ActorAggregate>
}

interface UpdateActorNamePort {
    fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto): Mono<ActorAggregate>
}

interface DeleteActorPort {
    fun deleteActor(id: Int): Mono<Boolean>
}

interface FindActorPort {
    fun findActorById(id: Int): Mono<ActorAggregate>
}

interface FindActorListPort {
    fun findActors(): Mono<ActorAggregate>
}
