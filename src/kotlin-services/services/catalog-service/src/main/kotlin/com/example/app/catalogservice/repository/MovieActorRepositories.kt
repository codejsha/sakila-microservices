package com.example.app.catalogservice.repository

import com.example.app.catalogservice.api.query.MovieActorEntity
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

interface MovieActorRepository : ReactiveCrudRepository<MovieActorEntity, Int>, CustomMovieActorRepository {
}

interface CustomMovieActorRepository {
    fun addActorToMovie(entity: MovieActorEntity): Mono<MovieActorEntity>
    fun removeActorFromMovie(movieId: Int, actorId: Int): Mono<Void>
}

@Repository
class CustomMovieActorRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CustomMovieActorRepository {
    override fun addActorToMovie(entity: MovieActorEntity): Mono<MovieActorEntity> {
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
