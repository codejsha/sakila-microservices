package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieTable
import com.example.app.catalog.application.port.output.*
import com.example.app.catalog.domain.dto.MovieRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MovieRepository : ReactiveCrudRepository<MovieTable, Int>, AddMoviePort, UpdateMoviePort, DeleteMoviePort,
    FindMoviePort, FindMovieListPort

class CustomMovieRepository(private val entityTemplate: R2dbcEntityTemplate) : AddMoviePort, UpdateMoviePort,
    DeleteMoviePort, FindMoviePort, FindMovieListPort {
    override fun addMovie(movieRequestDto: MovieRequestDto): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    override fun updateMovie(id: Int, movieRequestDto: MovieRequestDto): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    override fun deleteMovie(id: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    override fun findMovieById(id: Int): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    override fun findMovies(): Flux<MovieAggregate> {
        TODO("Not yet implemented")
    }
}
