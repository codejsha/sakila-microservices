package com.example.app.catalogservice.query

import com.example.app.catalogservice.api.command.MovieActorAddedEvent
import com.example.app.catalogservice.api.command.MovieActorRemovedEvent
import com.example.app.catalogservice.api.query.MovieActorEntity
import com.example.app.catalogservice.repository.MovieActorRepository
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component
import java.util.*

@Component
@ProcessingGroup("movieCast")
class MovieCastHandler(
    private val movieActorRepository: MovieActorRepository
) {
    @EventHandler
    fun on(event: MovieActorAddedEvent) {
        val movieActor = MovieActorEntity(UUID.randomUUID(), event.movieId, event.actorId)
        movieActorRepository.addActorToMovie(movieActor).subscribe()
    }

    @EventHandler
    fun on(event: MovieActorRemovedEvent) {
        movieActorRepository.removeActorFromMovie(event.movieId, event.actorId).subscribe()
    }
}
