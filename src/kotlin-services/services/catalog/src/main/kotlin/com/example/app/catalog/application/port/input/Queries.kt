package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.cqrs.QueryPort

// actor

interface GetActorQuery : QueryPort<ActorAggregate> {
    fun findActor(id: Int)
}

interface GetActorListQuery : QueryPort<List<ActorAggregate>> {
    fun findActors()
}

// movie

interface GetMovieQuery : QueryPort<MovieAggregate> {
    fun findMovie(id: Int)
}

interface GetMovieListQuery : QueryPort<List<MovieAggregate>> {
    fun findMovies()
}
