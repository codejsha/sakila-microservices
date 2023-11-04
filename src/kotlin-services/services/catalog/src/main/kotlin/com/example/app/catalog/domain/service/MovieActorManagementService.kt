package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.ActorInMovieActorAddCommand
import com.example.app.catalog.application.port.input.ActorInMovieActorRemoveCommand
import com.example.app.catalog.application.usecase.MovieActorManagementUseCase
import com.example.app.catalog.infrastructure.adapter.output.database.MovieActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieActorManagementService(
    private val movieActorRepository: MovieActorRepository
) : MovieActorManagementUseCase {
    @Transactional
    override fun addActorInMovieActor(actorInMovieActorAddCommand: ActorInMovieActorAddCommand): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun removeActorInMovieActor(actorInMovieActorRemoveCommand: ActorInMovieActorRemoveCommand): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
