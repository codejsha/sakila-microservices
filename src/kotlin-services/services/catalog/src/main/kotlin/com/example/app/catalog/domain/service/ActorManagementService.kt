package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.ActorAddCommand
import com.example.app.catalog.application.port.input.ActorDeleteCommand
import com.example.app.catalog.application.port.input.ActorNameUpdateCommand
import com.example.app.catalog.application.usecase.ActorManagementUseCase
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.infrastructure.adapter.output.persistence.database.ActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class ActorManagementService(
    private val actorRepository: ActorRepository
) : ActorManagementUseCase {
    @Transactional
    override fun addActor(actorAddCommand: ActorAddCommand): Mono<ActorAggregate> {
        val aggregate = ActorAggregate(
            firstName = actorAddCommand.actorAddRequestDto.firstName,
            lastName = actorAddCommand.actorAddRequestDto.lastName
        )
        val record = aggregate.toRecord()
        return actorRepository.save(record).map { ActorAggregate.fromRecord(it) }
    }

    @Transactional
    override fun updateActorName(actorNameUpdateCommand: ActorNameUpdateCommand): Mono<ActorAggregate> {
        val aggregate = ActorAggregate(
            actorId = actorNameUpdateCommand.id,
            firstName = actorNameUpdateCommand.actorNameUpdateRequestDto.firstName,
            lastName = actorNameUpdateCommand.actorNameUpdateRequestDto.lastName
        )
        val record = aggregate.toRecord()
        return actorRepository.save(record).map { ActorAggregate.fromRecord(it) }
    }

    @Transactional
    override fun deleteActor(actorDeleteCommand: ActorDeleteCommand): Mono<Boolean> {
        return actorRepository.deleteById(actorDeleteCommand.id).then(Mono.fromCallable { true })
    }
}
