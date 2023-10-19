package com.example.shared.infrastructure.adapter.event

fun arePropertiesBlank(obj: Any, properties: List<String>): Boolean {
    return obj::class.members
        .filter { it.name in properties }
        .all { prop ->
            val value = prop.call(obj) as? String
            value?.isBlank() == true
        }
}
