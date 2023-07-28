package com.example.app.catalog.application.port.output

import reactor.core.publisher.Mono

interface IncludeActorInMovieActorPort {
    fun includeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
}

interface ExcludeActorFromMovieActorPort {
    fun excludeActorFromMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
}
