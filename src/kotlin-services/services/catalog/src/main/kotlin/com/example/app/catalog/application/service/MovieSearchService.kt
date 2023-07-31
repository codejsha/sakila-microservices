package com.example.app.catalog.application.service

import com.example.app.catalog.adapter.output.persistence.repository.MovieRepository
import com.example.app.catalog.application.usecase.MovieSearchUseCase
import com.example.app.catalog.domain.entity.MovieAggregate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieSearchService(
    private val movieRepository: MovieRepository
) : MovieSearchUseCase {
    @Transactional(readOnly = true)
    override fun findMovie(movieId: Int): Mono<MovieAggregate> {
        return movieRepository.findMovieById(movieId)
    }

    @Transactional(readOnly = true)
    override fun findMovies(): Mono<MovieAggregate> {
        return movieRepository.findMovies()
    }
}
