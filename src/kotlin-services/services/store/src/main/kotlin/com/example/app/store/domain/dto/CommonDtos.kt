package com.example.app.store.domain.dto

import jakarta.validation.constraints.Size

open class FullName(
    @Size(min = 1, max = 45, message = "First name must be between 1 and 45 characters")
    open val firstName: String,
    @Size(min = 1, max = 45, message = "Last name must be between 1 and 45 characters")
    open val lastName: String
)
