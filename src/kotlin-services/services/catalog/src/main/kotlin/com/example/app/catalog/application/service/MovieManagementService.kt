package com.example.app.catalog.application.service

import com.example.app.catalog.adapter.output.persistence.repository.MovieRepository
import com.example.app.catalog.application.usecase.MovieManagementUseCase
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.app.catalog.domain.entity.MovieAggregate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieManagementService(
    private val movieRepository: MovieRepository
) : MovieManagementUseCase {
    @Transactional
    override fun addMovie(movieAddRequestDto: MovieAddRequestDto): Mono<MovieAggregate> {
        return movieRepository.addMovie(movieAddRequestDto)
    }

    @Transactional
    override fun updateMovie(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto): Mono<MovieAggregate> {
        return movieRepository.updateMovie(id, movieUpdateRequestDto)
    }

    @Transactional
    override fun deleteMovie(id: Int): Mono<Boolean> {
        return movieRepository.deleteMovie(id)
    }
}
