package com.example.app.catalog.infrastructure.adapter.output.database

import com.example.app.catalog.domain.record.MovieRecord
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MovieRepository : ReactiveCrudRepository<MovieRecord, Int>
