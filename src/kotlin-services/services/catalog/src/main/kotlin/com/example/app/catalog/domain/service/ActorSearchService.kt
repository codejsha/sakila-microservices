package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.ActorGetQuery
import com.example.app.catalog.application.port.input.ActorListGetQuery
import com.example.app.catalog.application.usecase.ActorSearchUseCase
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.infrastructure.adapter.output.database.ActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class ActorSearchService(
    private val actorRepository: ActorRepository
) : ActorSearchUseCase {
    @Transactional(readOnly = true)
    override fun findActor(actorGetQuery: ActorGetQuery): Mono<ActorAggregate> {
        return actorRepository.findById(actorGetQuery.id)
            .map { ActorAggregate(it.actorId, it.firstName, it.lastName) }
    }

    @Transactional(readOnly = true)
    override fun findActors(actorListGetQuery: ActorListGetQuery): Mono<List<ActorAggregate>> {
        val page = actorListGetQuery.elementRequest.page
        val size = actorListGetQuery.elementRequest.size
        return actorRepository.findAll()
            .skip((page - 1) * size)
            .take(size)
            .collectList()
            .map { it.map { actor -> ActorAggregate(actor.actorId, actor.firstName, actor.lastName) } }
    }
}
