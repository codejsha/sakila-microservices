package com.example.app.catalogservice.api

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

// actor

open class ActorData(open val firstName: String, open val lastName: String)

// movie

open class MovieData(
    open val title: String,
    open val description: String?,
    open val releaseYear: LocalDate?,
    open val languageId: Language,
    open val originalLanguageId: Language?,
    open val rentalDuration: Int,
    open val rentalRate: BigDecimal,
    open val length: Int?,
    open val replacementCost: BigDecimal,
    open val rating: MovieRating?,
    open val specialFeatures: EnumSet<SpecialFeature>?
)
