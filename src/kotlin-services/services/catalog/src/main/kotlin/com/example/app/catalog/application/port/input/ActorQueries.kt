package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.shared.application.port.BaseQuery

data class ActorGetQuery(val id: Int) : BaseQuery<ActorAggregate>()
class ActorListGetQuery : BaseQuery<List<ActorAggregate>>()
