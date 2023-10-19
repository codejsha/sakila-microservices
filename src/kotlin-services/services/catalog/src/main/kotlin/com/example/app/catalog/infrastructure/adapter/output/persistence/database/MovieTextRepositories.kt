package com.example.app.catalog.infrastructure.adapter.output.persistence.database

import com.example.app.catalog.domain.record.MovieTextRecord
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MovieTextRepository : ReactiveCrudRepository<MovieTextRecord, Int>
