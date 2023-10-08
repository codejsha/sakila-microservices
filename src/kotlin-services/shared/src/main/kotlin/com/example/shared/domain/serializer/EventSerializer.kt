package com.example.shared.domain.serializer

import com.example.shared.infrastructure.adapter.event.BaseEvent
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class EventSerializer(
    private val objectMapper: ObjectMapper
) : Serializer<BaseEvent> {
    override fun serialize(topic: String?, data: BaseEvent?): ByteArray {
        if (data == null) return ByteArray(0)

        try {
            return objectMapper.writeValueAsBytes(data)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }

        throw RuntimeException("Error serializing event: $data")
    }
}
