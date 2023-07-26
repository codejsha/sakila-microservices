package com.example.app.catalog.application.service

import com.example.app.catalog.adapter.output.persistence.repository.ActorRepository
import com.example.app.catalog.application.usecase.ActorSearchUseCase
import com.example.app.catalog.domain.entity.ActorAggregate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ActorSearchService(
    private val actorRepository: ActorRepository
) : ActorSearchUseCase {
    @Transactional(readOnly = true)
    override fun findActor(actorId: Int): Mono<ActorAggregate> {
        return actorRepository.findActorById(actorId)
    }

    @Transactional(readOnly = true)
    override fun findActors(): Flux<ActorAggregate> {
        return actorRepository.findActors()
    }
}
