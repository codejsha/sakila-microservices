package com.example.shared.domain.entity

import com.example.shared.application.port.BaseCommand
import com.example.shared.application.port.BaseQuery
import com.example.shared.infrastructure.adapter.event.BaseEvent

interface CommandHandler<C : BaseCommand> {
    fun handleCommand(command: C) : List<BaseEvent>
}

interface QueryHandler<Q : BaseQuery<R>, R> {
    fun handleQuery(query: Q): R
}

interface EventHandler<E : BaseEvent> {
    fun handleEvent(event: E)
}
