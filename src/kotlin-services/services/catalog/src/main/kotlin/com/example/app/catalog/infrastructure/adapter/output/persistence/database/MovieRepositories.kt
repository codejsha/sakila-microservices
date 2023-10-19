package com.example.app.catalog.infrastructure.adapter.output.persistence.database

import com.example.app.catalog.application.port.output.MovieManagementPort
import com.example.app.catalog.application.port.output.MovieSearchPort
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.app.catalog.domain.record.MovieRecord
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface MovieRepository : ReactiveCrudRepository<MovieRecord, Int>, MovieManagementPort, MovieSearchPort

class CustomMovieRepository(private val entityTemplate: R2dbcEntityTemplate) : MovieManagementPort, MovieSearchPort {
    override fun addMovie(movieAddRequestDto: MovieAddRequestDto): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    override fun updateMovie(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    override fun deleteMovie(id: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    override fun findMovieById(id: Int): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    override fun findMovies(): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }
}
