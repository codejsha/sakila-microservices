package com.example.app.catalog.application.port.input

import com.example.shared.application.port.BaseQuery
import com.example.shared.infrastructure.adapter.web.ElementRequest

data class MovieGetQuery(val id: Int) : BaseQuery()
class MovieListGetQuery(val elementRequest: ElementRequest) : BaseQuery()
