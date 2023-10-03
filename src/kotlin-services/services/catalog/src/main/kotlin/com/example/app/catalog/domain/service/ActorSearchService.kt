package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.ActorGetQuery
import com.example.app.catalog.application.port.input.ActorListGetQuery
import com.example.app.catalog.application.usecase.ActorSearchUseCase
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository.ActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class ActorSearchService(
    private val actorRepository: ActorRepository
) : ActorSearchUseCase {
    @Transactional(readOnly = true)
    override fun findActor(actorGetQuery: ActorGetQuery): Mono<ActorAggregate> {
        return actorRepository.findActorById(actorGetQuery.id)
    }

    @Transactional(readOnly = true)
    override fun findActors(actorListGetQuery: ActorListGetQuery): Mono<ActorAggregate> {
        return actorRepository.findActors()
    }
}
