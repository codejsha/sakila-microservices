package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.shared.cqrs.CommandPort

interface AddActorCommand : CommandPort {
    fun execute(actorAddRequestDto: ActorAddRequestDto)
}

interface UpdateActorNameCommand : CommandPort {
    fun execute(id: Int, actorNameUpdateRequestDto: ActorNameUpdateRequestDto)
}

interface DeleteActorCommand : CommandPort {
    fun execute(id: Int)
}
