package com.example.app.catalog.application.port.input

import com.example.shared.application.port.BaseCommand

data class ActorInMovieActorAddCommand(val movieId: Int, val actorId: Int) : BaseCommand()
data class ActorInMovieActorRemoveCommand(val movieId: Int, val actorId: Int) : BaseCommand()
