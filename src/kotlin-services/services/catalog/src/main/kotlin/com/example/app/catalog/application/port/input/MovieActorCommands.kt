package com.example.app.catalog.application.port.input

import com.example.shared.cqrs.CommandPort

data class ActorInMovieActorAddCommand(val movieId: Int, val actorId: Int) : CommandPort()
data class ActorInMovieActorRemoveCommand(val movieId: Int, val actorId: Int) : CommandPort()
