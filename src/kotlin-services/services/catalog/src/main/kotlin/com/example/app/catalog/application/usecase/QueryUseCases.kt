package com.example.app.catalog.application.usecase

interface ActorSearchUseCase {
    fun findActor(actorId: Int)
    fun findActors()
}

interface MovieSearchUseCase {
    fun findMovie(movieId: Int)
    fun findMovies()
}
