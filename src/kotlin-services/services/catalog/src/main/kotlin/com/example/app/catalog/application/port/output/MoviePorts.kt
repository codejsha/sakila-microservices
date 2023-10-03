package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.MovieRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Mono

interface MovieManagementPort {
    fun addMovie(movieRequestDto: MovieRequestDto): Mono<MovieAggregate>
    fun updateMovie(id: Int, movieRequestDto: MovieRequestDto): Mono<MovieAggregate>
    fun deleteMovie(id: Int): Mono<Boolean>
}

interface MovieSearchPort {
    fun findMovieById(id: Int): Mono<MovieAggregate>
    fun findMovies(): Mono<MovieAggregate>
}
