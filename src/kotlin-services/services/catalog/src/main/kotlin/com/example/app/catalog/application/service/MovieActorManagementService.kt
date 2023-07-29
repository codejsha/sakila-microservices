package com.example.app.catalog.application.service

import com.example.app.catalog.adapter.output.persistence.repository.MovieToMoviePortActorRepositoryToMovie
import com.example.app.catalog.application.usecase.MovieActorManagementUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieActorManagementService(
    private val movieActorRepository: MovieToMoviePortActorRepositoryToMovie
) : MovieActorManagementUseCase {
    @Transactional
    override fun assignActorToMovie(movieId: Int, actorId: Int): Mono<Boolean> {
        return movieActorRepository.assignActorToMovie(movieId, actorId)
    }

    @Transactional
    override fun unassignActorToMovie(movieId: Int, actorId: Int): Mono<Boolean> {
        return movieActorRepository.unassignActorToMovie(movieId, actorId)
    }
}
