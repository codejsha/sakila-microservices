package com.example.app.catalogservice.repository

import com.example.app.catalogservice.api.query.MovieTextEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

interface MovieTextRepository : ReactiveCrudRepository<MovieTextEntity, Int>, CustomMovieTextRepository {
}

interface CustomMovieTextRepository {
}

@Repository
class CustomMovieTextRepositoryImpl : CustomMovieTextRepository {
}
