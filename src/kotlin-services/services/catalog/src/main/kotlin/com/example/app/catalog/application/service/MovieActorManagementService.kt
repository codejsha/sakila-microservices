package com.example.app.catalog.application.service

import com.example.app.catalog.application.usecase.MovieActorManagementUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieActorManagementService : MovieActorManagementUseCase {
    @Transactional
    override fun includeActorInMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun excludeActorFromMovieActor(movieId: Int, actorId: Int): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
