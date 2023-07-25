package com.example.app.catalog.application.service

import com.example.app.catalog.application.usecase.ActorManagementUseCase
import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.entity.ActorAggregate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class ActorManagementService : ActorManagementUseCase {
    @Transactional
    override fun addActor(actorAddRequestDto: ActorAddRequestDto): Mono<ActorAggregate> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto): Mono<ActorAggregate> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteActor(id: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
