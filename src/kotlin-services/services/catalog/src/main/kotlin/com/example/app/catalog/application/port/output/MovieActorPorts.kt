package com.example.app.catalog.application.port.output

import reactor.core.publisher.Mono

interface MovieActorManagementPort {
    fun addActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
    fun removeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
}
