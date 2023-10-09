package com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository

import com.example.app.catalog.application.port.output.MovieActorManagementPort
import com.example.app.catalog.domain.record.MovieActorRecord
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface MovieActorRepository : ReactiveCrudRepository<MovieActorRecord, Int>, MovieActorManagementPort

class CustomMovieActorRepository(private val entityTemplate: R2dbcEntityTemplate) : MovieActorManagementPort {
    override fun addActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    override fun removeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
