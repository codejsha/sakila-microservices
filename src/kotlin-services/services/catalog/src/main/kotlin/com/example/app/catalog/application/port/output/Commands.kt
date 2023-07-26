package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Mono

// actor

interface AddActorPort {
    fun addActor(actorAddRequestDto: ActorAddRequestDto): Mono<ActorAggregate>
}

interface UpdateActorNamePort {
    fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto): Mono<ActorAggregate>
}

interface DeleteActorPort {
    fun deleteActor(id: Int): Mono<Boolean>
}

// movie

interface AddMoviePort {
    fun addMovie(movieAddRequestDto: MovieAddRequestDto): Mono<MovieAggregate>
}

interface UpdateMoviePort {
    fun updateMovie(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto): Mono<MovieAggregate>
}

interface DeleteMoviePort {
    fun deleteMovie(id: Int): Mono<Boolean>
}

// move cast

interface IncludeActorInMovieActorPort {
    fun includeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
}

interface ExcludeActorFromMovieActorPort {
    fun excludeActorFromMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
}
