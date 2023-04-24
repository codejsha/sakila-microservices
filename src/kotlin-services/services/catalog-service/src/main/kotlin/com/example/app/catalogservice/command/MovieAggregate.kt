package com.example.app.catalogservice.command

import com.example.app.catalogservice.api.Language
import com.example.app.catalogservice.api.MovieRating
import com.example.app.catalogservice.api.SpecialFeature
import com.example.app.catalogservice.api.command.*
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import kotlin.properties.Delegates

@Aggregate
class MovieAggregate {
    @AggregateIdentifier
    private var movieId: Int? = null
    private lateinit var title: String
    private var description: String? = null
    private var releaseYear: LocalDate? = null
    private lateinit var languageId: Language
    private var originalLanguageId: Language? = null
    private var rentalDuration by Delegates.notNull<Int>()
    private lateinit var rentalRate: BigDecimal
    private var length: Int? = null
    private var replacementCost by Delegates.notNull<BigDecimal>()
    private var rating: MovieRating? = null
    private var specialFeatures: EnumSet<SpecialFeature>? = null

    private constructor()

    @CommandHandler
    constructor(command: CreateMovieCommand) {
        AggregateLifecycle.apply(MovieCreatedEvent(command.id, command.movieCreateRequestData))
    }

    @CommandHandler
    fun handle(command: UpdateMovieCommand) {
        AggregateLifecycle.apply(MovieUpdatedEvent(command.movieId, command.movieUpdateRequestData))
    }

    @CommandHandler
    fun handle(command: DeleteMovieCommand) {
        AggregateLifecycle.apply(MovieDeletedEvent(command.movieId))
    }

    @EventSourcingHandler
    fun on(event: MovieCreatedEvent) {
        movieId = event.movieId
        title = event.movieCreateRequestData.title
        description = event.movieCreateRequestData.description
        releaseYear = event.movieCreateRequestData.releaseYear
        languageId = event.movieCreateRequestData.languageId
        originalLanguageId = event.movieCreateRequestData.originalLanguageId
        rentalDuration = event.movieCreateRequestData.rentalDuration
        rentalRate = event.movieCreateRequestData.rentalRate
        length = event.movieCreateRequestData.length
        replacementCost = event.movieCreateRequestData.replacementCost
        rating = event.movieCreateRequestData.rating
        specialFeatures = event.movieCreateRequestData.specialFeatures
    }

    @EventSourcingHandler
    fun on(event: MovieUpdatedEvent) {
        movieId = event.movieId
        title = event.movieUpdateRequestData.title
        description = event.movieUpdateRequestData.description
        releaseYear = event.movieUpdateRequestData.releaseYear
        languageId = event.movieUpdateRequestData.languageId
        originalLanguageId = event.movieUpdateRequestData.originalLanguageId
        rentalDuration = event.movieUpdateRequestData.rentalDuration
        rentalRate = event.movieUpdateRequestData.rentalRate
        length = event.movieUpdateRequestData.length
        replacementCost = event.movieUpdateRequestData.replacementCost
        rating = event.movieUpdateRequestData.rating
        specialFeatures = event.movieUpdateRequestData.specialFeatures
    }

    @EventSourcingHandler
    fun on(event: MovieDeletedEvent) {
        AggregateLifecycle.markDeleted()
    }
}
