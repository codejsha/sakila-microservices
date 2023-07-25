package com.example.app.catalog.application.port.output

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto

// actor

interface AddActorPort {
    fun addActor(actorAddRequestDto: ActorAddRequestDto)
}

interface UpdateActorNamePort {
    fun updateActorName(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto)
}

interface DeleteActorPort {
    fun deleteActor(id: Int)
}

// movie

interface AddMoviePort {
    fun addMovie(id: Int, movieAddRequestDto: MovieAddRequestDto)
}

interface UpdateMovieNamePort {
    fun updateMovieName(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto)
}

interface DeleteMoviePort {
    fun deleteMovie(id: Int)
}

// move cast

interface IncludeActorInMovieActorPort {
    fun includeActorInMovieActor(movieId: Int, actorId: Int)
}

interface ExcludeActorFromMovieActorPort {
    fun excludeActorFromMovieActor(movieId: Int, actorId: Int)
}
