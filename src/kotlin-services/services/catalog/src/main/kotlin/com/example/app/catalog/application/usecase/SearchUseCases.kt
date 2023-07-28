package com.example.app.catalog.application.usecase

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ActorSearchUseCase {
    fun findActor(actorId: Int): Mono<ActorAggregate>
    fun findActors(): Flux<ActorAggregate>
}

interface MovieSearchUseCase {
    fun findMovie(movieId: Int): Mono<MovieAggregate>
    fun findMovies(): Flux<MovieAggregate>
}
