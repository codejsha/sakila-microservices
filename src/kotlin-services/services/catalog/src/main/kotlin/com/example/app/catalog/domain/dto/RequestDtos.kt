package com.example.app.catalog.domain.dto

import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class ActorAddRequestDto(override val firstName: String, override val lastName: String) :
    FullName(firstName, lastName)

data class ActorNameUpdateRequestDto(override val firstName: String, override val lastName: String) :
    FullName(firstName, lastName)

data class MovieRequestDto(
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
    val specialFeatures: EnumSet<SpecialFeature>?
)

data class ActorToMovieAssignRequestDto(val actorId: Int)
data class ActorToMovieUnassignRequestDto(val actorId: Int)
