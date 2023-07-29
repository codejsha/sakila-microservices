package com.example.app.catalog.domain.dto

import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class ActorAddResponseDto(val actorId: Int, override val firstName: String, override val lastName: String) :
    ActorName(firstName, lastName)

data class MovieResponseDto(
    val movieId: Int,
    val title: String,
    val description: String?,
    val releaseYear: LocalDate?,
    val languageId: Language,
    val originalLanguageId: Language?,
    val rentalDuration: Int,
    val rentalRate: BigDecimal,
    val length: Int?,
    val replacementCost: BigDecimal,
    val rating: MovieRating?,
    val specialFeatures: EnumSet<SpecialFeature>?,
)
