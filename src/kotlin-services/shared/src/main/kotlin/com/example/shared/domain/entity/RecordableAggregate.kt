package com.example.shared.domain.entity

interface RecordableAggregate {
    fun toRecord(): Any
}
