package com.example.app.catalog.adapter.output.persistence.repository

import com.example.app.catalog.adapter.output.persistence.table.MovieTextTable
import com.example.app.catalog.application.port.output.ExcludeActorFromMovieActorPort
import com.example.app.catalog.application.port.output.IncludeActorInMovieActorPort
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface MovieTextRepository : ReactiveCrudRepository<MovieTextTable, Int>
