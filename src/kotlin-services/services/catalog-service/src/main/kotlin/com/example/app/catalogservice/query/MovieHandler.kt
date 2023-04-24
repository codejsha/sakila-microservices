package com.example.app.catalogservice.query

import com.example.app.catalogservice.api.command.MovieCreatedEvent
import com.example.app.catalogservice.api.command.MovieDeletedEvent
import com.example.app.catalogservice.api.command.MovieUpdatedEvent
import com.example.app.catalogservice.api.query.FindMovie
import com.example.app.catalogservice.api.query.FindMovies
import com.example.app.catalogservice.query.mapper.MovieMapper
import com.example.app.catalogservice.repository.MovieRepository
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryUpdateEmitter
import org.springframework.stereotype.Component

@Component
@ProcessingGroup("movie")
class MovieHandler(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper,
    private val queryUpdateEmitter: QueryUpdateEmitter
) {
    @EventHandler
    fun on(event: MovieCreatedEvent) {
        val movie = movieMapper.mapEventDataToEntity(event.movieId, event.movieCreateRequestData)
        movieRepository.createMovie(movie).subscribe()

        queryUpdateEmitter.emit(
            FindMovie::class.java,
            { query -> query.movieId == event.movieId },
            movieMapper.mapEntityToResponseData(movie)
        )
        queryUpdateEmitter.emit(
            FindMovies::class.java,
            { true },
            movieMapper.mapEntityToResponseData(movie)
        )
    }

    @EventHandler
    fun on(event: MovieUpdatedEvent) {
        val movie = movieMapper.mapEventDataToEntity(event.movieId, event.movieUpdateRequestData)
        movieRepository.save(movie).subscribe()

        queryUpdateEmitter.emit(
            FindMovie::class.java,
            { query -> query.movieId == event.movieId },
            movieMapper.mapEntityToResponseData(movie)
        )
        queryUpdateEmitter.emit(
            FindMovies::class.java,
            { true },
            movieMapper.mapEntityToResponseData(movie)
        )
    }

    @EventHandler
    fun on(event: MovieDeletedEvent) {
        movieRepository.deleteById(event.movieId).subscribe()

        queryUpdateEmitter.emit(
            FindMovie::class.java,
            { query -> query.movieId == event.movieId },
            null
        )
        queryUpdateEmitter.emit(
            FindMovies::class.java,
            { true },
            null
        )
    }
}
