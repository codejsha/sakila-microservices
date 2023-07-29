package com.example.app.catalog.application.port.output

import reactor.core.publisher.Mono

interface AssignActorToMoviePortPort {
    fun assignActorToMovie(movieId: Int, actorId: Int): Mono<Boolean>
}

interface UnassignActorToMoviePort {
    fun unassignActorToMovie(movieId: Int, actorId: Int): Mono<Boolean>
}
