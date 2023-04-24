package com.example.app.catalogservice.query

import com.example.app.catalogservice.api.command.ActorCreatedEvent
import com.example.app.catalogservice.api.command.ActorDeletedEvent
import com.example.app.catalogservice.api.command.ActorNameUpdatedEvent
import com.example.app.catalogservice.api.query.FindActor
import com.example.app.catalogservice.api.query.FindActors
import com.example.app.catalogservice.query.mapper.ActorMapper
import com.example.app.catalogservice.repository.ActorRepository
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryUpdateEmitter
import org.springframework.stereotype.Component

@Component
@ProcessingGroup("actor")
class ActorHandler(
    private val actorRepository: ActorRepository,
    private val actorMapper: ActorMapper,
    private val queryUpdateEmitter: QueryUpdateEmitter
) {
    @EventHandler
    fun on(event: ActorCreatedEvent) {
        val actor = actorMapper.mapEventDataToEntity(event.actorId, event.actorCreateRequestData)
        actorRepository.createActor(actor).subscribe()

        queryUpdateEmitter.emit(
            FindActor::class.java,
            { query -> query.actorId == event.actorId },
            actorMapper.mapEntityToResponseData(actor)
        )
        queryUpdateEmitter.emit(
            FindActors::class.java,
            { true },
            actorMapper.mapEntityToResponseData(actor)
        )
    }

    @EventHandler
    fun on(event: ActorNameUpdatedEvent) {
        val actor = actorMapper.mapEventDataToEntity(event.actorId, event.actorNameUpdateRequestData)
        actorRepository.save(actor).subscribe()

        queryUpdateEmitter.emit(
            FindActor::class.java,
            { query -> query.actorId == event.actorId },
            actorMapper.mapEntityToResponseData(actor)
        )
        queryUpdateEmitter.emit(
            FindActors::class.java,
            { true },
            actorMapper.mapEntityToResponseData(actor)
        )
    }

    @EventHandler
    fun on(event: ActorDeletedEvent) {
        actorRepository.deleteById(event.actorId).subscribe()

        queryUpdateEmitter.emit(
            FindActor::class.java,
            { query -> query.actorId == event.actorId },
            null
        )
        queryUpdateEmitter.emit(
            FindActors::class.java,
            { true },
            null
        )
    }
}
