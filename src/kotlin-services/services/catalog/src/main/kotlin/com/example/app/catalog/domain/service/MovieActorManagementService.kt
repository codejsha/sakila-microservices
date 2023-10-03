package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.ActorInMovieActorAddCommand
import com.example.app.catalog.application.port.input.ActorInMovieActorRemoveCommand
import com.example.app.catalog.application.usecase.MovieActorManagementUseCase
import com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository.MovieActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieActorManagementService(
    private val movieActorRepository: MovieActorRepository
) : MovieActorManagementUseCase {
    @Transactional
    override fun addActorInMovieActor(actorInMovieActorAddCommand: ActorInMovieActorAddCommand): Mono<Boolean> {
        return movieActorRepository.addActorInMovieActor(
            movieId = actorInMovieActorAddCommand.movieId,
            actorId = actorInMovieActorAddCommand.actorId
        )
    }

    @Transactional
    override fun removeActorInMovieActor(actorInMovieActorRemoveCommand: ActorInMovieActorRemoveCommand): Mono<Boolean> {
        return movieActorRepository.removeActorInMovieActor(
            movieId = actorInMovieActorRemoveCommand.movieId,
            actorId = actorInMovieActorRemoveCommand.actorId
        )
    }
}
