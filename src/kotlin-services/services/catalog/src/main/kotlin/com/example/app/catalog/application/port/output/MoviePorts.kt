package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import reactor.core.publisher.Mono

interface MovieManagementPort {
    fun addMovie(movieAddRequestDto: MovieAddRequestDto): Mono<MovieAggregate>
    fun updateMovie(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto): Mono<MovieAggregate>
    fun deleteMovie(id: Int): Mono<Boolean>
}

interface MovieSearchPort {
    fun findMovieById(id: Int): Mono<MovieAggregate>
    fun findMovies(): Mono<MovieAggregate>
}
