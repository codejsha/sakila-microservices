package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieTable
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

interface MovieRepository : ReactiveCrudRepository<MovieTable, Int>, CustomMovieRepository

interface CustomMovieRepository {
    fun createMovie(entity: MovieTable): Mono<MovieTable>
}

@Repository
class CustomMovieRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CustomMovieRepository {
    override fun createMovie(entity: MovieTable): Mono<MovieTable> {
        return entityTemplate.insert(entity)
    }
}
