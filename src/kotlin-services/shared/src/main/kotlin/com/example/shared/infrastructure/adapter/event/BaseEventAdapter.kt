package com.example.shared.infrastructure.adapter.event

import org.springframework.kafka.core.KafkaTemplate

open class BaseEventAdapter(
    private val producer: KafkaTemplate<String, BaseEvent>
) {
    open fun publish(topic: String, event: BaseEvent) {
        producer.send(topic, event.uuid.toString(), event)
    }
}
