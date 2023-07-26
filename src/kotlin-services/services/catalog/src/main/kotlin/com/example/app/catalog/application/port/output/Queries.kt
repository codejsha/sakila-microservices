package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

// actor

interface FindActorPort {
    fun findActorById(id: Int): Mono<ActorAggregate>
}

interface FindActorListPort {
    fun findActors(): Flux<ActorAggregate>
}

// movie

interface FindMoviePort {
    fun findMovieById(id: Int): Mono<MovieAggregate>
}

interface FindMovieListPort {
    fun findMovies(): Flux<MovieAggregate>
}
