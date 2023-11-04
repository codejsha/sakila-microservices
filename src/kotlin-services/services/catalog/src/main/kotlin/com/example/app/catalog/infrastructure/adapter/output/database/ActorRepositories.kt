package com.example.app.catalog.infrastructure.adapter.output.database

import com.example.app.catalog.domain.record.ActorRecord
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ActorRepository : ReactiveCrudRepository<ActorRecord, Int>
