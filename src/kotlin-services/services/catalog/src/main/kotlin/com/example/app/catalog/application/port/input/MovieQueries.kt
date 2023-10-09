package com.example.app.catalog.application.port.input

import com.example.shared.application.port.BaseQuery

data class MovieGetQuery(val id: Int) : BaseQuery()
class MovieListGetQuery : BaseQuery()
