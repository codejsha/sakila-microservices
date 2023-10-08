package com.example.app.catalog.application.usecase

import com.example.app.catalog.application.port.input.ActorInMovieActorAddCommand
import com.example.app.catalog.application.port.input.ActorInMovieActorRemoveCommand
import reactor.core.publisher.Mono

interface MovieActorManagementUseCase {
    fun addActorInMovieActor(actorInMovieActorAddCommand: ActorInMovieActorAddCommand): Mono<Boolean>
    fun removeActorInMovieActor(actorInMovieActorRemoveCommand: ActorInMovieActorRemoveCommand): Mono<Boolean>
}
