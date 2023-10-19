package com.example.app.catalog.domain.entity

import com.example.app.catalog.application.port.input.MovieAddCommand
import com.example.app.catalog.application.port.input.MovieDeleteCommand
import com.example.app.catalog.application.port.input.MovieUpdateCommand
import com.example.app.catalog.domain.dto.MovieAddedEvent
import com.example.app.catalog.domain.dto.MovieDeletedEvent
import com.example.app.catalog.domain.dto.MovieUpdatedEvent
import com.example.app.catalog.domain.record.MovieRecord
import com.example.app.catalog.domain.vo.Language
import com.example.app.catalog.domain.vo.MovieRating
import com.example.app.catalog.domain.vo.SpecialFeature
import com.example.shared.application.port.BaseCommand
import com.example.shared.domain.entity.CommandHandler
import com.example.shared.domain.entity.EventHandler
import com.example.shared.domain.entity.RecordableAggregate
import com.example.shared.infrastructure.adapter.event.BaseEvent
import com.example.shared.infrastructure.adapter.event.arePropertiesBlank
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

class MovieAggregate(
    var movieId: Int? = null,
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
    private var isDeleted: Boolean = false
) : CommandHandler<BaseCommand>, EventHandler<BaseEvent>, RecordableAggregate {
    companion object {
        fun create(events: List<BaseEvent>): MovieAggregate {
            val movieAggregate = MovieAggregate(
                title = "",
                description = "",
                releaseYear = null,
                languageId = Language.ENGLISH,
                originalLanguageId = null,
                rentalDuration = 0,
                rentalRate = BigDecimal.ZERO,
                length = null,
                replacementCost = BigDecimal.ZERO,
                rating = null,
                specialFeatures = null
            )
            events.forEach { movieAggregate.handleEvent(it) }
            return movieAggregate
        }

        fun fromRecord(record: MovieRecord): MovieAggregate {
            return MovieAggregate(
                movieId = record.movieId,
                title = record.title,
                description = record.description,
                releaseYear = record.releaseYear,
                languageId = record.languageId,
                originalLanguageId = record.originalLanguageId,
                rentalDuration = record.rentalDuration,
                rentalRate = record.rentalRate,
                length = record.length,
                replacementCost = record.replacementCost,
                rating = record.rating,
                specialFeatures = record.specialFeatures
            )
        }
    }

    override fun handleCommand(command: BaseCommand): List<BaseEvent> {
        return when (command) {
            is MovieAddCommand -> handleMovieAddCommand(command)
            is MovieUpdateCommand -> handleMovieUpdateCommand(command)
            is MovieDeleteCommand -> handleMovieDeleteCommand(command)
            else -> throw IllegalArgumentException("Unknown command $command")
        }
    }

    private fun handleMovieAddCommand(command: MovieAddCommand): List<BaseEvent> {
        require(!arePropertiesBlank(command.movieAddRequestDto,
            listOf("title", "languageId", "rentalDuration", "rentalRate", "replacementCost"))) {
            "Required properties cannot be blank"
        }
        return listOf(MovieAddedEvent(command.movieAddRequestDto)
        )
    }

    private fun handleMovieUpdateCommand(command: MovieUpdateCommand): List<BaseEvent> {
        require(!arePropertiesBlank(command.movieUpdateRequestDto,
            listOf("title", "languageId", "rentalDuration", "rentalRate", "replacementCost"))) {
            "Required properties cannot be blank"
        }
        return listOf(MovieUpdatedEvent(command.id, command.movieUpdateRequestDto))
    }

    private fun handleMovieDeleteCommand(command: MovieDeleteCommand): List<BaseEvent> {
        return listOf(MovieDeletedEvent(command.id))
    }

    override fun handleEvent(event: BaseEvent) {
        when (event) {
            is MovieAddedEvent -> handleMovieAddedEvent(event)
            is MovieUpdatedEvent -> handleMovieUpdatedEvent(event)
            is MovieDeletedEvent -> handleMovieDeletedEvent(event)
            else -> throw IllegalArgumentException("Unknown event $event")
        }
    }

    private fun handleMovieAddedEvent(event: MovieAddedEvent) {
        title = event.movieAddRequestDto.title
        description = event.movieAddRequestDto.description
        releaseYear = event.movieAddRequestDto.releaseYear
        languageId = event.movieAddRequestDto.languageId
        originalLanguageId = event.movieAddRequestDto.originalLanguageId
        rentalDuration = event.movieAddRequestDto.rentalDuration
        rentalRate = event.movieAddRequestDto.rentalRate
        length = event.movieAddRequestDto.length
        replacementCost = event.movieAddRequestDto.replacementCost
        rating = event.movieAddRequestDto.rating
        specialFeatures = event.movieAddRequestDto.specialFeatures
    }

    private fun handleMovieUpdatedEvent(event: MovieUpdatedEvent) {
        title = event.movieUpdateRequestDto.title
        description = event.movieUpdateRequestDto.description
        releaseYear = event.movieUpdateRequestDto.releaseYear
        languageId = event.movieUpdateRequestDto.languageId
        originalLanguageId = event.movieUpdateRequestDto.originalLanguageId
        rentalDuration = event.movieUpdateRequestDto.rentalDuration
        rentalRate = event.movieUpdateRequestDto.rentalRate
        length = event.movieUpdateRequestDto.length
        replacementCost = event.movieUpdateRequestDto.replacementCost
        rating = event.movieUpdateRequestDto.rating
        specialFeatures = event.movieUpdateRequestDto.specialFeatures
    }

    private fun handleMovieDeletedEvent(event: MovieDeletedEvent) {
        isDeleted = true
    }

    override fun toRecord(): MovieRecord {
        return MovieRecord(
            movieId = movieId,
            title = title,
            description = description,
            releaseYear = releaseYear,
            languageId = languageId,
            originalLanguageId = originalLanguageId,
            rentalDuration = rentalDuration,
            rentalRate = rentalRate,
            length = length,
            replacementCost = replacementCost,
            rating = rating,
            specialFeatures = specialFeatures
        )
    }
}
