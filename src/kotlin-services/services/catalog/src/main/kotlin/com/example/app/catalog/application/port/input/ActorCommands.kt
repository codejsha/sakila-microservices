package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.ActorAddRequestDto
import com.example.app.catalog.domain.dto.ActorNameUpdateRequestDto
import com.example.shared.application.port.BaseCommand

data class ActorAddCommand(val actorAddRequestDto: ActorAddRequestDto) : BaseCommand()
data class ActorNameUpdateCommand(val id: Int, val actorNameUpdateRequestDto: ActorNameUpdateRequestDto) : BaseCommand()
data class ActorDeleteCommand(val id: Int) : BaseCommand()
