package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.application.port.BaseQuery

data class MovieGetQuery(val id: Int) : BaseQuery<MovieAggregate>()
class MovieListGetQuery : BaseQuery<List<MovieAggregate>>()
