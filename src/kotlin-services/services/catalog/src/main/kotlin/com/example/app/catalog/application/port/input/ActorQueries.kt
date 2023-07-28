package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.cqrs.QueryPort

interface GetActorQuery : QueryPort<ActorAggregate> {
    fun findActor(id: Int)
}

interface GetActorListQuery : QueryPort<List<ActorAggregate>> {
    fun findActors()
}
