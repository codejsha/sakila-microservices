package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AddMoviePort {
    fun addMovie(movieAddRequestDto: MovieAddRequestDto): Mono<MovieAggregate>
}

interface UpdateMoviePort {
    fun updateMovie(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto): Mono<MovieAggregate>
}

interface DeleteMoviePort {
    fun deleteMovie(id: Int): Mono<Boolean>
}

interface FindMoviePort {
    fun findMovieById(id: Int): Mono<MovieAggregate>
}

interface FindMovieListPort {
    fun findMovies(): Flux<MovieAggregate>
}
