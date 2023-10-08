package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.cqrs.QueryPort

data class MovieGetQuery(val id: Int) : QueryPort<MovieAggregate>()
class MovieListGetQuery : QueryPort<List<MovieAggregate>>()
