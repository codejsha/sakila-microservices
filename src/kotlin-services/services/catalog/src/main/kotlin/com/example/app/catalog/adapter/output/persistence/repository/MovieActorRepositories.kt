package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieActorTable
import com.example.app.catalog.application.port.output.ExcludeActorFromMovieActorPort
import com.example.app.catalog.application.port.output.IncludeActorInMovieActorPort
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface MovieActorRepository : ReactiveCrudRepository<MovieActorTable, Int>, IncludeActorInMovieActorPort,
    ExcludeActorFromMovieActorPort

class CustomMovieActorRepository(private val entityTemplate: R2dbcEntityTemplate) : IncludeActorInMovieActorPort,
    ExcludeActorFromMovieActorPort {
    override fun includeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    override fun excludeActorFromMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
