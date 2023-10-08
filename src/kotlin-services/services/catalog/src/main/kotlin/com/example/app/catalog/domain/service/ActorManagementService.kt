package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.ActorAddCommand
import com.example.app.catalog.application.port.input.ActorDeleteCommand
import com.example.app.catalog.application.port.input.ActorNameUpdateCommand
import com.example.app.catalog.application.usecase.ActorManagementUseCase
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository.ActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class ActorManagementService(
    private val actorRepository: ActorRepository
) : ActorManagementUseCase {
    @Transactional
    override fun addActor(actorAddCommand: ActorAddCommand): Mono<ActorAggregate> {
        return actorRepository.addActor(actorAddCommand.actorAddRequestDto)
    }

    @Transactional
    override fun updateActorName(actorNameUpdateCommand: ActorNameUpdateCommand): Mono<ActorAggregate> {
        return actorRepository.updateActorName(
            actorNameUpdateCommand.id,
            actorNameUpdateCommand.actorNameUpdateRequestDto
        )
    }

    @Transactional
    override fun deleteActor(actorDeleteCommand: ActorDeleteCommand): Mono<Boolean> {
        return actorRepository.deleteActor(actorDeleteCommand.id)
    }
}
