package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.shared.cqrs.PortCommand

// actor

interface AddActorCommand : PortCommand {
    fun execute(actorAddRequestDto: ActorAddRequestDto)
}

interface UpdateActorNameCommand : PortCommand {
    fun execute(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto)
}

interface DeleteActorCommand : PortCommand {
    fun execute(id: Int)
}

// movie

interface AddMovieCommand : PortCommand {
    fun execute(id: Int, movieAddRequestDto: MovieAddRequestDto)
}

interface UpdateMovieCommand : PortCommand {
    fun execute(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto)
}

interface DeleteMovieCommand : PortCommand {
    fun execute(id: Int)
}

// move cast

interface IncludeActorInMovieActorCommand : PortCommand {
    fun execute(movieId: Int, actorId: Int)
}

interface ExcludeActorInMovieActorCommand : PortCommand {
    fun execute(movieId: Int, actorId: Int)
}
