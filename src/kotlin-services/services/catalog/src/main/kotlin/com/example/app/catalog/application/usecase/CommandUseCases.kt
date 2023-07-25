package com.example.app.catalog.application.usecase

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Mono

interface ActorManagementUseCase {
    fun addActor(actorAddRequestDto: ActorAddRequestDto): Mono<ActorAggregate>
    fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto): Mono<ActorAggregate>
    fun deleteActor(id: Int): Mono<Boolean>
}

interface MovieManagementUseCase {
    fun addMovie(movieAddRequestDto: MovieAddRequestDto): Mono<MovieAggregate>
    fun updateMovie(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto): Mono<MovieAggregate>
    fun deleteMovie(id: Int): Mono<Boolean>
}

interface MovieActorManagementUseCase {
    fun includeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
    fun excludeActorFromMovieActor(movieId: Int, actorId: Int): Mono<Boolean>
}
