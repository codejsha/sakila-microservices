package com.example.app.catalog.application.port.input

import com.example.shared.cqrs.CommandPort

interface IncludeActorInMovieActorCommand : CommandPort {
    fun execute(movieId: Int, actorId: Int)
}

interface ExcludeActorInMovieActorCommand : CommandPort {
    fun execute(movieId: Int, actorId: Int)
}
