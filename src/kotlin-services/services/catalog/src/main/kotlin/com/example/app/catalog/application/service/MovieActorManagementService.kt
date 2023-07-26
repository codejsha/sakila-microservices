package com.example.app.catalog.application.service

import com.example.app.catalog.adapter.output.persistence.repository.MovieActorRepository
import com.example.app.catalog.application.usecase.MovieActorManagementUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieActorManagementService(
    private val movieActorRepository: MovieActorRepository
) : MovieActorManagementUseCase {
    @Transactional
    override fun includeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        return movieActorRepository.includeActorInMovieActor(movieId, actorId)
    }

    @Transactional
    override fun excludeActorFromMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        return movieActorRepository.excludeActorFromMovieActor(movieId, actorId)
    }
}
