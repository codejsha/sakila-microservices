package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieActorTable
import com.example.app.catalog.application.port.output.AssignActorToMoviePortPort
import com.example.app.catalog.application.port.output.UnassignActorToMoviePort
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface MovieToMoviePortActorRepositoryToMovie : ReactiveCrudRepository<MovieActorTable, Int>,
    AssignActorToMoviePortPort,
    UnassignActorToMoviePort

class CustomMovieActorRepositoryToMovieToMoviePort(private val entityTemplate: R2dbcEntityTemplate) :
    AssignActorToMoviePortPort,
    UnassignActorToMoviePort {
    override fun assignActorToMovie(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    override fun unassignActorToMovie(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
