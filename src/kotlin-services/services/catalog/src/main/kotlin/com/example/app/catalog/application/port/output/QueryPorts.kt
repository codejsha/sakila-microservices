package com.example.app.catalog.application.port.output

// actor

interface FindActorPort {
    fun findActorById(id: Int)
}

interface FindActorListPort {
    fun findActors()
}

// movie

interface FindMoviePort {
    fun findMovieById(id: Int)
}

interface FindMovieListPort {
    fun findMovies()
}
