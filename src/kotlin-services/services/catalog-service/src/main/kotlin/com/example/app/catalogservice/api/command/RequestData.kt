package com.example.app.catalogservice.api.command

import com.example.app.catalogservice.api.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

// actor

data class ActorCreateRequestData(override val firstName: String, override val lastName: String) :
    ActorData(firstName, lastName) {
    init {
        require(firstName.length in 1..45) { "First name must be between 1 and 45 characters" }
        require(lastName.length in 1..45) { "Last name must be between 1 and 45 characters" }
    }
}

data class ActorNameUpdateRequestData(override val firstName: String, override val lastName: String) :
    ActorData(firstName, lastName) {
    init {
        require(firstName.length in 1..45) { "First name must be between 1 and 45 characters" }
        require(lastName.length in 1..45) { "Last name must be between 1 and 45 characters" }
    }
}

// movie

data class MovieCreateRequestData(
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
    override val specialFeatures: EnumSet<SpecialFeature>?
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

data class MovieUpdateRequestData(
    override val title: String,
    override val description: String,
    override val releaseYear: LocalDate,
    override val languageId: Language,
    override val originalLanguageId: Language,
    override val rentalDuration: Int,
    override val rentalRate: BigDecimal,
    override val length: Int,
    override val replacementCost: BigDecimal,
    override val rating: MovieRating,
    override val specialFeatures: EnumSet<SpecialFeature>
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
        require(description.length in 1..65535) { "Description must be between 1 and 65535 characters" }
    }
}

// movie cast

data class MovieAddActorRequestData(val actorId: Int)
data class MovieRemoveActorRequestData(val actorId: Int)
