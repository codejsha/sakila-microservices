package com.example.app.catalog.application.service

import com.example.app.catalog.application.usecase.ActorSearchUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ActorSearchService : ActorSearchUseCase {
    @Transactional(readOnly = true)
    override fun findActor(actorId: Int) {
        TODO("Not yet implemented")
    }

    @Transactional(readOnly = true)
    override fun findActors() {
        TODO("Not yet implemented")
    }
}
