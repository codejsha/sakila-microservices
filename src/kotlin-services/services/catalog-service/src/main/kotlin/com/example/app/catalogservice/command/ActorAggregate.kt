package com.example.app.catalogservice.command

import com.example.app.catalogservice.api.command.*
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class ActorAggregate {
    @AggregateIdentifier
    private var actorId: Int? = null
    private lateinit var firstName: String
    private lateinit var lastName: String

    private constructor()

    @CommandHandler
    constructor(command: CreateActorCommand) {
        AggregateLifecycle.apply(ActorCreatedEvent(command.id, command.actorCreateRequestData))
    }

    @CommandHandler
    fun handle(command: UpdateActorNameCommand) {
        AggregateLifecycle.apply(ActorNameUpdatedEvent(command.actorId, command.actorNameUpdateRequestData))
    }

    @CommandHandler
    fun handle(command: DeleteActorCommand) {
        AggregateLifecycle.apply(ActorDeletedEvent(command.actorId))
    }

    @EventSourcingHandler
    fun on(event: ActorCreatedEvent) {
        actorId = event.actorId
        firstName = event.actorCreateRequestData.firstName
        lastName = event.actorCreateRequestData.lastName
    }

    @EventSourcingHandler
    fun on(event: ActorNameUpdatedEvent) {
        firstName = event.actorNameUpdateRequestData.firstName
        lastName = event.actorNameUpdateRequestData.lastName
    }

    @EventSourcingHandler
    fun on(event: ActorDeletedEvent) {
        AggregateLifecycle.markDeleted()
    }
}
