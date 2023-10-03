package com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.repository

import com.example.app.catalog.infrastructure.adapter.output.persistence.mysql.table.MovieTextTable
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MovieTextRepository : ReactiveCrudRepository<MovieTextTable, Int>
