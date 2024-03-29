package com.example.app.catalog.domain.record

import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import com.example.shared.domain.record.BaseRecord
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Table(name = "actor", schema = "sakila")
data class ActorRecord(
    @Id @Column("actor_id") var actorId: Int? = null,
    @Column("first_name") @Size(min = 1, max = 45) var firstName: String,
    @Column("last_name") @Size(min = 1, max = 45) var lastName: String,
) : BaseRecord()

@Table(name = "film", schema = "sakila")
data class MovieRecord(
    @Id @Column("film_id") var movieId: Int? = null,
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
) : BaseRecord()

@Table(name = "film_actor", schema = "sakila")
data class MovieActorRecord(
    @Id @Column("film_actor_id") var movieActorId: Int,
    @Column("actor_id") var actorId: Int,
    @Column("film_id") var movieId: Int,
) : BaseRecord()

@Table(name = "film_text", schema = "sakila")
data class MovieTextRecord(
    @Id @Column("film_id") var movieId: Int,
    @Column("title") @Size(min = 1, max = 255) var title: String,
    @Column("description") @Size(min = 1, max = 65535) var description: String? = null,
) : BaseRecord()
