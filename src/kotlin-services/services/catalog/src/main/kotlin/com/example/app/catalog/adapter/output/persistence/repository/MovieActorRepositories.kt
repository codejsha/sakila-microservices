package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieActorTable
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

interface MovieActorRepository : ReactiveCrudRepository<MovieActorTable, Int>, CustomMovieActorRepository

interface CustomMovieActorRepository {
    fun addActorToMovie(entity: MovieActorTable): Mono<MovieActorTable>
    fun removeActorFromMovie(movieId: Int, actorId: Int): Mono<Void>
}

@Repository
class CustomMovieActorRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CustomMovieActorRepository {
    override fun addActorToMovie(entity: MovieActorTable): Mono<MovieActorTable> {
        return entityTemplate.insert(entity)
    }

    override fun removeActorFromMovie(movieId: Int, actorId: Int): Mono<Void> {
        val sql = "DELETE FROM sakila.film_actor WHERE film_id = $movieId AND actor_id = $actorId"
        return entityTemplate.databaseClient.sql(sql)
            .fetch()
            .rowsUpdated()
            .then()
    }
}
