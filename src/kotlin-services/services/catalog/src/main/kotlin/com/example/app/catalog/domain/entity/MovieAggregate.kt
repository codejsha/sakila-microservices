package com.example.app.catalog.domain.entity

import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class MovieAggregate(
    var movieId: Int?,
    var title: String,
    var description: String?,
    var releaseYear: LocalDate?,
    var languageId: Language,
    var originalLanguageId: Language?,
    var rentalDuration: Int,
    var rentalRate: BigDecimal,
    var length: Int?,
    var replacementCost: BigDecimal,
    var rating: MovieRating?,
    var specialFeatures: EnumSet<SpecialFeature>?,
)
