package com.example.shared.infrastructure.adapter.event

fun arePropertiesNotBlank(obj: Any, properties: List<String>): Boolean {
    return obj::class.members
        .filter { it.name in properties }
        .all { prop ->
            val value = prop.call(obj) as? String
            value?.isNotBlank() == true
        }
}
