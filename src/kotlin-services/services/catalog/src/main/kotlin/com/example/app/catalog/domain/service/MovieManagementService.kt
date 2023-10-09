package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.MovieAddCommand
import com.example.app.catalog.application.port.input.MovieDeleteCommand
import com.example.app.catalog.application.port.input.MovieUpdateCommand
import com.example.app.catalog.application.usecase.MovieManagementUseCase
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository.MovieRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieManagementService(
    private val movieRepository: MovieRepository
) : MovieManagementUseCase {
    @Transactional
    override fun addMovie(movieAddCommand: MovieAddCommand): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateMovie(movieUpdateCommand: MovieUpdateCommand): Mono<MovieAggregate> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteMovie(movieDeleteCommand: MovieDeleteCommand): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}
