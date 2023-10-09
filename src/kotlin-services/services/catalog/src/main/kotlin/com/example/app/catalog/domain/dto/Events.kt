package com.example.app.catalog.domain.dto

import com.example.shared.infrastructure.adapter.event.BaseEvent

data class ActorAddedEvent(val actorAddRequestDto: ActorAddRequestDto) : BaseEvent()
data class ActorNameUpdatedEvent(val id: Int, val actorNameUpdateRequestDto: ActorNameUpdateRequestDto) : BaseEvent()
data class ActorDeletedEvent(val id: Int) : BaseEvent()

data class MovieAddedEvent(val movieAddRequestDto: MovieAddRequestDto) : BaseEvent()
data class MovieUpdatedEvent(val id: Int, val movieUpdateRequestDto: MovieUpdateRequestDto) : BaseEvent()
data class MovieDeletedEvent(val id: Int) : BaseEvent()

data class ActorInMovieActorAddedEvent(val movieId: Int, val actorId: Int) : BaseEvent()
data class ActorInMovieActorRemovedCommand(val movieId: Int, val actorId: Int) : BaseEvent()
