package com.example.app.catalogservice.api.query

import com.example.app.catalogservice.api.Language
import com.example.app.catalogservice.api.MovieData
import com.example.app.catalogservice.api.MovieRating
import com.example.app.catalogservice.api.SpecialFeature
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

// actor

data class ActorResponseData(val actorId: Int, val firstName: String, val lastName: String)

// movie

data class MovieResponseData(
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
    val actors: List<ActorResponseData>?
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
