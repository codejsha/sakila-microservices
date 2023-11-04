package com.example.app.catalog.infrastructure.adapter.output.database

import com.example.app.catalog.domain.record.MovieActorRecord
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MovieActorRepository : ReactiveCrudRepository<MovieActorRecord, Int>
