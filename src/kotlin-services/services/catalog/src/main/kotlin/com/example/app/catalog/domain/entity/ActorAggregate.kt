package com.example.app.catalog.domain.entity

import java.time.LocalDate

data class ActorAggregate(
    var actorId: Int?,
    var firstName: String,
    var lastName: String,
    var lastUpdate: LocalDate?
)
