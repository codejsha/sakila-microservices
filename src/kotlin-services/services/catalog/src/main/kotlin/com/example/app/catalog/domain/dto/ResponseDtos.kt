package com.example.app.catalog.domain.dto

import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

// actor

data class ActorResponseDto(val actorId: Int, val firstName: String, val lastName: String)

// movie

data class MovieResponseDto(
    val movieId: Int,
    override val title: String,
    override val description: String?,
    override val releaseYear: LocalDate?,
    override val languageId: Language,
    override val originalLanguageId: Language?,
    override val rentalDuration: Int,
    override val rentalRate: BigDecimal,
    override val length: Int?,
    override val replacementCost: BigDecimal,
    override val rating: MovieRating?,
    override val specialFeatures: EnumSet<SpecialFeature>?,
    val actors: List<ActorResponseDto>?
) : MovieData(
    title,
    description,
    releaseYear,
    languageId,
    originalLanguageId,
    rentalDuration,
    rentalRate,
    length,
    replacementCost,
    rating,
    specialFeatures
) {
    init {
        require(title.length in 1..128) { "Title must be between 1 and 128 characters" }
        require(description?.length in 1..65535) { "Description must be between 1 and 65535 characters" }
    }
}
