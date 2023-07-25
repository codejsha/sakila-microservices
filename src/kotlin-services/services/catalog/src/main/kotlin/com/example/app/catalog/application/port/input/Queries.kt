package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.cqrs.PortQuery

// actor

interface GetActorQuery : PortQuery<ActorAggregate> {
    fun findActor(id: Int)
}

interface GetActorListQuery : PortQuery<List<ActorAggregate>> {
    fun findActors()
}

// movie

interface GetMovieQuery : PortQuery<MovieAggregate> {
    fun findMovie(id: Int)
}

interface GetMovieListQuery : PortQuery<List<MovieAggregate>> {
    fun findMovies()
}
