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
        return movieRepository.addMovie(movieAddCommand.movieRequestDto)
    }

    @Transactional
    override fun updateMovie(movieUpdateCommand: MovieUpdateCommand): Mono<MovieAggregate> {
        return movieRepository.updateMovie(
            movieUpdateCommand.id,
            movieUpdateCommand.movieRequestDto
        )
    }

    @Transactional
    override fun deleteMovie(movieDeleteCommand: MovieDeleteCommand): Mono<Boolean> {
        return movieRepository.deleteMovie(movieDeleteCommand.id)
    }
}
