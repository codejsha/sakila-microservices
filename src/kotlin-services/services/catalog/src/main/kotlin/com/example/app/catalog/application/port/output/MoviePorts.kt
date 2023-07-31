package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.MovieRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Mono

interface AddMoviePort {
    fun addMovie(movieRequestDto: MovieRequestDto): Mono<MovieAggregate>
}

interface UpdateMoviePort {
    fun updateMovie(id: Int, movieRequestDto: MovieRequestDto): Mono<MovieAggregate>
}

interface DeleteMoviePort {
    fun deleteMovie(id: Int): Mono<Boolean>
}

interface FindMoviePort {
    fun findMovieById(id: Int): Mono<MovieAggregate>
}

interface FindMovieListPort {
    fun findMovies(): Mono<MovieAggregate>
}
