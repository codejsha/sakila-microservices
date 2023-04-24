package com.example.app.catalogservice.repository

import com.example.app.catalogservice.api.query.ActorEntity
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

interface ActorRepository : ReactiveCrudRepository<ActorEntity, Int>, CustomActorRepository {
}

interface CustomActorRepository {
    fun createActor(entity: ActorEntity): Mono<ActorEntity>
}

@Repository
class CustomActorRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CustomActorRepository {
    override fun createActor(entity: ActorEntity): Mono<ActorEntity> {
        return entityTemplate.insert(entity)
            .subscribeOn(Schedulers.boundedElastic())
    }
}
