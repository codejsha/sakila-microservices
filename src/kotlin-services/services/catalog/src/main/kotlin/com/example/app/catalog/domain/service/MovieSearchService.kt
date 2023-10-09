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
        return movieRepository.findById(movieGetQuery.id)
            .map {
                MovieAggregate(
                    movieId = it.movieId,
                    title = it.title,
                    description = it.description,
                    releaseYear = it.releaseYear,
                    languageId = it.languageId,
                    originalLanguageId = it.originalLanguageId,
                    rentalDuration = it.rentalDuration,
                    rentalRate = it.rentalRate,
                    length = it.length,
                    replacementCost = it.replacementCost,
                    rating = it.rating,
                    specialFeatures = it.specialFeatures)
            }
    }

    @Transactional(readOnly = true)
    override fun findMovies(movieListGetQuery: MovieListGetQuery): Mono<List<MovieAggregate>> {
        val page = movieListGetQuery.elementRequest.page
        val size = movieListGetQuery.elementRequest.size
        return movieRepository.findAll()
            .skip((page - 1) * size)
            .take(size)
            .collectList()
            .map {
                it.map { movie ->
                    MovieAggregate(
                        movieId = movie.movieId,
                        title = movie.title,
                        description = movie.description,
                        releaseYear = movie.releaseYear,
                        languageId = movie.languageId,
                        originalLanguageId = movie.originalLanguageId,
                        rentalDuration = movie.rentalDuration,
                        rentalRate = movie.rentalRate,
                        length = movie.length,
                        replacementCost = movie.replacementCost,
                        rating = movie.rating,
                        specialFeatures = movie.specialFeatures)
                }
            }
    }
}
