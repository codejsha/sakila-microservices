package com.example.app.catalog.domain.dto

data class ActorAddedEvent(val id: Int, val actorAddRequestDto: ActorAddRequestDto)
data class ActorNameUpdatedEvent(val id: Int, val actorNameUpdateRequestDto: ActorNameUpdateRequestDto)
data class ActorDeletedEvent(val id: Int)

data class MovieAddedEvent(val id: Int, val movieRequestDto: MovieRequestDto)
data class MovieUpdatedEvent(val id: Int, val movieRequestDto: MovieRequestDto)
data class MovieDeletedEvent(val id: Int)

data class MovieActorAssignedEvent(val movieId: Int, val actorId: Int)
data class MovieActorUnassignedEvent(val movieId: Int, val actorId: Int)
