package com.example.app.catalogservice.command

import com.example.app.catalogservice.api.command.AddMovieActorCommand
import com.example.app.catalogservice.api.command.MovieActorAddedEvent
import com.example.app.catalogservice.api.command.MovieActorRemovedEvent
import com.example.app.catalogservice.api.command.RemoveMovieActorCommand
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class MovieCastAggregate {
    @AggregateIdentifier
    private var movieCastId: String? = null
    private var movieId: Int? = null
    private var actorId: Int? = null

    private constructor()

    @CommandHandler
    constructor(command: AddMovieActorCommand) {
        AggregateLifecycle.apply(MovieActorAddedEvent(command.movieId, command.actorId))
    }

    @CommandHandler
    fun handle(command: RemoveMovieActorCommand) {
        AggregateLifecycle.apply(MovieActorRemovedEvent(command.movieId, command.actorId))
    }

    @EventSourcingHandler
    fun on(event: MovieActorAddedEvent) {
        movieCastId = "${event.movieId}-${event.actorId}"
        actorId = event.actorId
        movieId = event.movieId
    }

    @EventSourcingHandler
    fun on(event: MovieActorRemovedEvent) {
        AggregateLifecycle.markDeleted()
    }
}
