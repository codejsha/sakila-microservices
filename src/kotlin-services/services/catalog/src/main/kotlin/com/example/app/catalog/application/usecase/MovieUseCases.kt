package com.example.app.catalog.application.usecase

import com.example.app.catalog.application.port.input.*
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Mono

interface MovieManagementUseCase {
    fun addMovie(movieAddCommand: MovieAddCommand): Mono<MovieAggregate>
    fun updateMovie(movieUpdateCommand: MovieUpdateCommand): Mono<MovieAggregate>
    fun deleteMovie(movieDeleteCommand: MovieDeleteCommand): Mono<Boolean>
}

interface MovieSearchUseCase {
    fun findMovie(movieGetQuery: MovieGetQuery): Mono<MovieAggregate>
    fun findMovies(movieListGetQuery: MovieListGetQuery): Mono<MovieAggregate>
}
