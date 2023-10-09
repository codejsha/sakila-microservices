package com.example.app.catalog.application.usecase

import com.example.app.catalog.application.port.input.*
import com.example.app.catalog.domain.entity.ActorAggregate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ActorManagementUseCase {
    fun addActor(actorAddCommand: ActorAddCommand): Mono<ActorAggregate>
    fun updateActorName(actorNameUpdateCommand: ActorNameUpdateCommand): Mono<ActorAggregate>
    fun deleteActor(actorDeleteCommand: ActorDeleteCommand): Mono<Boolean>
}

interface ActorSearchUseCase {
    fun findActor(actorGetQuery: ActorGetQuery): Mono<ActorAggregate>
    fun findActors(actorListGetQuery: ActorListGetQuery): Flux<ActorAggregate>
}
