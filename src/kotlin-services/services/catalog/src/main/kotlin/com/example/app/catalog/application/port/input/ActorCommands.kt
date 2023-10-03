package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.shared.cqrs.CommandPort

data class ActorAddCommand(val actorAddRequestDto: ActorAddRequestDto) : CommandPort()
data class ActorNameUpdateCommand(val id: Int, val actorNameUpdateRequestDto: ActorNameUpdateRequestDto) : CommandPort()
data class ActorDeleteCommand(val id: Int) : CommandPort()
