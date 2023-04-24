package com.example.app.catalogservice.api.command

// actor

data class ActorCreatedEvent(val actorId: Int, val actorCreateRequestData: ActorCreateRequestData)
data class ActorNameUpdatedEvent(val actorId: Int, val actorNameUpdateRequestData: ActorNameUpdateRequestData)
data class ActorDeletedEvent(val actorId: Int)

// movie

data class MovieCreatedEvent(val movieId: Int, val movieCreateRequestData: MovieCreateRequestData)
data class MovieUpdatedEvent(val movieId: Int, val movieUpdateRequestData: MovieUpdateRequestData)
data class MovieDeletedEvent(val movieId: Int)

// movie cast

data class MovieActorAddedEvent(val movieId: Int, val actorId: Int)
data class MovieActorRemovedEvent(val movieId: Int, val actorId: Int)
