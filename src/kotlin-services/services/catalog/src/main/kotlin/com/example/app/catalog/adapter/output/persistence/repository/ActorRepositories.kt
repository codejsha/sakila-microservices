package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.ActorTable
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

interface ActorRepository : ReactiveCrudRepository<ActorTable, Int>, CustomActorRepository

interface CustomActorRepository {
    fun createActor(entity: ActorTable): Mono<ActorTable>
}

@Repository
class CustomActorRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CustomActorRepository {
    override fun createActor(entity: ActorTable): Mono<ActorTable> {
        return entityTemplate.insert(entity)
            .subscribeOn(Schedulers.boundedElastic())
    }
}
