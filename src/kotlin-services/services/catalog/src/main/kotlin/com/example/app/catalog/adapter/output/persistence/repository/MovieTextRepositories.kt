package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieTextTable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

interface MovieTextRepository : ReactiveCrudRepository<MovieTextTable, Int>, CustomMovieTextRepository

interface CustomMovieTextRepository

@Repository
class CustomMovieTextRepositoryImpl : CustomMovieTextRepository
