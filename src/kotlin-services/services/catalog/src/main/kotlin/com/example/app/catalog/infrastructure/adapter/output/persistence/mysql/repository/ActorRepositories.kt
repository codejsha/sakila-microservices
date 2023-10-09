package com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository

import com.example.app.catalog.application.port.output.ActorManagementPort
import com.example.app.catalog.application.port.output.ActorSearchPort
import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.record.ActorRecord
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface ActorRepository : ReactiveCrudRepository<ActorRecord, Int>, ActorManagementPort, ActorSearchPort

class CustomActorRepository(private val entityTemplate: R2dbcEntityTemplate) : ActorManagementPort, ActorSearchPort {
    override fun addActor(actorAddRequestDto: ActorAddRequestDto): Mono<ActorAggregate> {
        TODO("Not yet implemented")
    }

    override fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto): Mono<ActorAggregate> {
        TODO("Not yet implemented")
    }

    override fun deleteActor(id: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    override fun findActorById(id: Int): Mono<ActorAggregate> {
        TODO("Not yet implemented")
    }

    override fun findActors(): Mono<ActorAggregate> {
        TODO("Not yet implemented")
    }
}
