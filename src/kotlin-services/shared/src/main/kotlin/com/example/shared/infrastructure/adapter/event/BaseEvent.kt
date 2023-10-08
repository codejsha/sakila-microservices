package com.example.shared.infrastructure.adapter.event

import com.fasterxml.jackson.annotation.JsonIgnore
import org.apache.kafka.common.Uuid

open class BaseEvent {
    @JsonIgnore
    open val uuid: Uuid = Uuid.randomUuid()
}
