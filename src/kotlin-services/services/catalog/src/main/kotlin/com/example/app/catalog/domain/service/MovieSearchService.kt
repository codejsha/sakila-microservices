package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.MovieGetQuery
import com.example.app.catalog.application.port.input.MovieListGetQuery
import com.example.app.catalog.application.usecase.MovieSearchUseCase
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository.MovieRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieSearchService(
    private val movieRepository: MovieRepository
) : MovieSearchUseCase {
    @Transactional(readOnly = true)
    override fun findMovie(movieGetQuery: MovieGetQuery): Mono<MovieAggregate> {
        return movieRepository.findMovieById(movieGetQuery.id)
    }

    @Transactional(readOnly = true)
    override fun findMovies(movieListGetQuery: MovieListGetQuery): Mono<MovieAggregate> {
        return movieRepository.findMovies()
    }
}
