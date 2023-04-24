package com.example.app.catalogservice.repository

import com.example.app.catalogservice.api.query.MovieEntity
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

interface MovieRepository : ReactiveCrudRepository<MovieEntity, Int>, CustomMovieRepository {
}

interface CustomMovieRepository {
    fun createMovie(entity: MovieEntity): Mono<MovieEntity>
}

@Repository
class CustomMovieRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CustomMovieRepository {
    override fun createMovie(entity: MovieEntity): Mono<MovieEntity> {
        return entityTemplate.insert(entity)
    }
}
