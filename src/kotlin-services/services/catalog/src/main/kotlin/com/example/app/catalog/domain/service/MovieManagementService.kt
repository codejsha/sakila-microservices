package com.example.app.catalog.domain.service

import com.example.app.catalog.application.port.input.MovieAddCommand
import com.example.app.catalog.application.port.input.MovieDeleteCommand
import com.example.app.catalog.application.port.input.MovieUpdateCommand
import com.example.app.catalog.application.usecase.MovieManagementUseCase
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.app.catalog.infrastructure.adapter.output.database.MovieRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class MovieManagementService(
    private val movieRepository: MovieRepository
) : MovieManagementUseCase {
    @Transactional
    override fun addMovie(movieAddCommand: MovieAddCommand): Mono<MovieAggregate> {
        val aggregate = MovieAggregate(
            title = movieAddCommand.movieAddRequestDto.title,
            description = movieAddCommand.movieAddRequestDto.description,
            releaseYear = movieAddCommand.movieAddRequestDto.releaseYear,
            languageId = movieAddCommand.movieAddRequestDto.languageId,
            originalLanguageId = movieAddCommand.movieAddRequestDto.originalLanguageId,
            rentalDuration = movieAddCommand.movieAddRequestDto.rentalDuration,
            rentalRate = movieAddCommand.movieAddRequestDto.rentalRate,
            length = movieAddCommand.movieAddRequestDto.length,
            replacementCost = movieAddCommand.movieAddRequestDto.replacementCost,
            rating = movieAddCommand.movieAddRequestDto.rating,
            specialFeatures = movieAddCommand.movieAddRequestDto.specialFeatures
        )
        val record = aggregate.toRecord()
        return movieRepository.save(record).map { MovieAggregate.fromRecord(it) }
    }

    @Transactional
    override fun updateMovie(movieUpdateCommand: MovieUpdateCommand): Mono<MovieAggregate> {
        val aggregate = MovieAggregate(
            movieId = movieUpdateCommand.id,
            title = movieUpdateCommand.movieUpdateRequestDto.title,
            description = movieUpdateCommand.movieUpdateRequestDto.description,
            releaseYear = movieUpdateCommand.movieUpdateRequestDto.releaseYear,
            languageId = movieUpdateCommand.movieUpdateRequestDto.languageId,
            originalLanguageId = movieUpdateCommand.movieUpdateRequestDto.originalLanguageId,
            rentalDuration = movieUpdateCommand.movieUpdateRequestDto.rentalDuration,
            rentalRate = movieUpdateCommand.movieUpdateRequestDto.rentalRate,
            length = movieUpdateCommand.movieUpdateRequestDto.length,
            replacementCost = movieUpdateCommand.movieUpdateRequestDto.replacementCost,
            rating = movieUpdateCommand.movieUpdateRequestDto.rating,
            specialFeatures = movieUpdateCommand.movieUpdateRequestDto.specialFeatures
        )
        val record = aggregate.toRecord()
        return movieRepository.save(record).map { MovieAggregate.fromRecord(it) }
    }

    @Transactional
    override fun deleteMovie(movieDeleteCommand: MovieDeleteCommand): Mono<Boolean> {
        return movieRepository.deleteById(movieDeleteCommand.id).then(Mono.fromCallable { true })
    }
}
