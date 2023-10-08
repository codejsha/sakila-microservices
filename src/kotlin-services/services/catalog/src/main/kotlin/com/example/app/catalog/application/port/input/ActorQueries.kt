package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.shared.cqrs.QueryPort

data class ActorGetQuery(val id: Int) : QueryPort<ActorAggregate>()
class ActorListGetQuery : QueryPort<List<ActorAggregate>>()
