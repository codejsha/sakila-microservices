package com.example.app.catalog.domain.dto

import jakarta.validation.constraints.Size

open class ActorName(
    @Size(min = 1, max = 45, message = "First name must be between 1 and 45 characters")
    open val firstName: String,
    @Size(min = 1, max = 45, message = "Last name must be between 1 and 45 characters")
    open val lastName: String
)
