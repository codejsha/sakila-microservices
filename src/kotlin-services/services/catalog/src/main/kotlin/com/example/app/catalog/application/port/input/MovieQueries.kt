package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.cqrs.QueryPort

interface GetMovieQuery : QueryPort<MovieAggregate> {
    fun findMovie(id: Int)
}

interface GetMovieListQuery : QueryPort<List<MovieAggregate>> {
    fun findMovies()
}
