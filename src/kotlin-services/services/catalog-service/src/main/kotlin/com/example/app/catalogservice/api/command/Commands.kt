package com.example.app.catalogservice.api.command

import org.axonframework.modelling.command.TargetAggregateIdentifier

// actor

data class CreateActorCommand(
    @TargetAggregateIdentifier val id: Int,
    val actorCreateRequestData: ActorCreateRequestData
)

data class UpdateActorNameCommand(
    @TargetAggregateIdentifier val actorId: Int, val actorNameUpdateRequestData: ActorNameUpdateRequestData
)

data class DeleteActorCommand(@TargetAggregateIdentifier val actorId: Int)

// movie

data class CreateMovieCommand(
    @TargetAggregateIdentifier val id: Int,
    val movieCreateRequestData: MovieCreateRequestData
)

data class UpdateMovieCommand(
    @TargetAggregateIdentifier val movieId: Int,
    val movieUpdateRequestData: MovieUpdateRequestData
)

data class DeleteMovieCommand(@TargetAggregateIdentifier val movieId: Int)

// move cast

data class AddMovieActorCommand(@TargetAggregateIdentifier val movieId: Int, val actorId: Int)
data class RemoveMovieActorCommand(@TargetAggregateIdentifier val movieId: Int, val actorId: Int)
