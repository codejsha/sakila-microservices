package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.shared.cqrs.CommandPort

// actor

interface AddActorCommand : CommandPort {
    fun execute(actorAddRequestDto: ActorAddRequestDto)
}

interface UpdateActorNameCommand : CommandPort {
    fun execute(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto)
}

interface DeleteActorCommand : CommandPort {
    fun execute(id: Int)
}

// movie

interface AddMovieCommand : CommandPort {
    fun execute(id: Int, movieAddRequestDto: MovieAddRequestDto)
}

interface UpdateMovieCommand : CommandPort {
    fun execute(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto)
}

interface DeleteMovieCommand : CommandPort {
    fun execute(id: Int)
}

// move cast

interface IncludeActorInMovieActorCommand : CommandPort {
    fun execute(movieId: Int, actorId: Int)
}

interface ExcludeActorInMovieActorCommand : CommandPort {
    fun execute(movieId: Int, actorId: Int)
}
