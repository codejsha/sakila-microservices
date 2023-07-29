package com.example.app.catalog.application.service

import com.example.app.catalog.adapter.output.persistence.repository.MovieRepository
import com.example.app.catalog.application.usecase.MovieManagementUseCase
import com.example.app.catalog.domain.dto.MovieRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieManagementService(
    private val movieRepository: MovieRepository
) : MovieManagementUseCase {
    @Transactional
    override fun addMovie(movieRequestDto: MovieRequestDto): Mono<MovieAggregate> {
        return movieRepository.addMovie(movieRequestDto)
    }

    @Transactional
    override fun updateMovie(id: Int, movieRequestDto: MovieRequestDto): Mono<MovieAggregate> {
        return movieRepository.updateMovie(id, movieRequestDto)
    }

    @Transactional
    override fun deleteMovie(id: Int): Mono<Boolean> {
        return movieRepository.deleteMovie(id)
    }
}
