package com.example.app.catalog.application.port.input

import com.example.shared.application.port.BaseQuery
import com.example.shared.infrastructure.adapter.web.ElementRequest

data class ActorGetQuery(val id: Int) : BaseQuery()
data class ActorListGetQuery(val elementRequest: ElementRequest) : BaseQuery()
