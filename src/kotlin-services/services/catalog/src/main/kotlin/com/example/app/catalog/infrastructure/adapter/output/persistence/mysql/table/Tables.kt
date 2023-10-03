package com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.table

import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Table(name = "actor", schema = "sakila")
data class ActorTable(
    @Id @Column("actor_id") var actorId: Int,
    @Column("first_name") @Size(min = 1, max = 45) var firstName: String,
    @Column("last_name") @Size(min = 1, max = 45) var lastName: String,
    @Column("last_update") @LastModifiedDate var lastUpdate: LocalDateTime? = null
)

@Table(name = "film", schema = "sakila")
data class MovieTable(
    @Id @Column("film_id") var movieId: Int,
    @Column("title") @Size(min = 1, max = 128) var title: String,
    @Column("description") @Size(min = 1, max = 65535) var description: String? = null,
    @Column("release_year") var releaseYear: LocalDate? = null,
    @Column("language_id") var languageId: Language,
    @Column("original_language_id") var originalLanguageId: Language? = null,
    @Column("rental_duration") var rentalDuration: Int = 3,
    @Column("rental_rate") var rentalRate: BigDecimal = BigDecimal("4.99"),
    @Column("length") var length: Int? = null,
    @Column("replacement_cost") var replacementCost: BigDecimal = BigDecimal("19.99"),
    @Column("rating") var rating: MovieRating? = MovieRating.G,
    @Column("special_features") var specialFeatures: EnumSet<SpecialFeature>? = null,
    @Column("last_update") @LastModifiedDate var lastUpdate: LocalDateTime? = null
)

@Table(name = "film_actor", schema = "sakila")
data class MovieActorTable(
    @Id @Column("film_actor_id") var movieActorId: Int,
    @Column("actor_id") var actorId: Int,
    @Column("film_id") var movieId: Int,
    @Column("last_update") @LastModifiedDate var lastUpdate: LocalDateTime? = null
)

@Table(name = "film_text", schema = "sakila")
data class MovieTextTable(
    @Id @Column("film_id") var movieId: Int,
    @Column("title") @Size(min = 1, max = 255) var title: String,
    @Column("description") @Size(min = 1, max = 65535) var description: String? = null,
    @Column("last_update") @LastModifiedDate var lastUpdate: LocalDateTime? = null
)
