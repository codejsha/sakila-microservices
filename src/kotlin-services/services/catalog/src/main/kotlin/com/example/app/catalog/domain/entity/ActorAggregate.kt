package com.example.app.catalog.domain.entity

import com.example.app.catalog.application.port.input.ActorAddCommand
import com.example.app.catalog.application.port.input.ActorDeleteCommand
import com.example.app.catalog.application.port.input.ActorNameUpdateCommand
import com.example.app.catalog.domain.dto.ActorAddedEvent
import com.example.app.catalog.domain.dto.ActorDeletedEvent
import com.example.app.catalog.domain.dto.ActorNameUpdatedEvent
import com.example.app.catalog.domain.record.ActorRecord
import com.example.shared.application.port.BaseCommand
import com.example.shared.domain.entity.CommandHandler
import com.example.shared.domain.entity.EventHandler
import com.example.shared.domain.entity.RecordableAggregate
import com.example.shared.infrastructure.adapter.event.BaseEvent
import com.example.shared.infrastructure.adapter.event.arePropertiesBlank

class ActorAggregate(
    var actorId: Int? = null,
    var firstName: String,
    var lastName: String,
    private var isDeleted: Boolean = false
) : CommandHandler<BaseCommand>, EventHandler<BaseEvent>, RecordableAggregate {
    companion object {
        fun create(events: List<BaseEvent>): ActorAggregate {
            val actorAggregate = ActorAggregate(firstName = "", lastName = "")
            events.forEach { actorAggregate.handleEvent(it) }
            return actorAggregate
        }

        fun fromRecord(record: ActorRecord): ActorAggregate {
            return ActorAggregate(
                actorId = record.actorId,
                firstName = record.firstName,
                lastName = record.lastName
            )
        }
    }

    override fun handleCommand(command: BaseCommand): List<BaseEvent> {
        return when (command) {
            is ActorAddCommand -> handleActorAddCommand(command)
            is ActorNameUpdateCommand -> handleActorNameUpdateCommand(command)
            is ActorDeleteCommand -> handleActorDeleteCommand(command)
            else -> throw IllegalArgumentException("Unknown command $command")
        }
    }

    private fun handleActorAddCommand(command: ActorAddCommand): List<BaseEvent> {
        require(arePropertiesBlank(command.actorAddRequestDto, listOf("firstName", "lastName"))) {
            "Required properties cannot be blank"
        }
        return listOf(ActorAddedEvent(command.actorAddRequestDto)
        )
    }

    private fun handleActorNameUpdateCommand(command: ActorNameUpdateCommand): List<BaseEvent> {
        require(!arePropertiesBlank(command.actorNameUpdateRequestDto, listOf("firstName", "lastName"))) {
            "First name and last name cannot be blank"
        }
        return listOf(ActorNameUpdatedEvent(command.id, command.actorNameUpdateRequestDto))
    }

    private fun handleActorDeleteCommand(command: ActorDeleteCommand): List<BaseEvent> {
        return listOf(ActorDeletedEvent(command.id))
    }

    override fun handleEvent(event: BaseEvent) {
        when (event) {
            is ActorAddedEvent -> handleActorAddedEvent(event)
            is ActorNameUpdatedEvent -> handleActorNameUpdatedEvent(event)
            is ActorDeletedEvent -> handleActorDeletedEvent(event)
            else -> throw IllegalArgumentException("Unknown event $event")
        }
    }

    private fun handleActorAddedEvent(event: ActorAddedEvent) {
        firstName = event.actorAddRequestDto.firstName
        lastName = event.actorAddRequestDto.lastName
    }

    private fun handleActorNameUpdatedEvent(event: ActorNameUpdatedEvent) {
        firstName = event.actorNameUpdateRequestDto.firstName
        lastName = event.actorNameUpdateRequestDto.lastName
    }

    private fun handleActorDeletedEvent(event: ActorDeletedEvent) {
        isDeleted = true
    }

    override fun toRecord(): ActorRecord {
        return ActorRecord(
            actorId = actorId,
            firstName = firstName,
            lastName = lastName
        )
    }
}
