package com.example.shared.domain.entity

import com.example.shared.domain.record.BaseRecord

interface RecordableAggregate {
    fun toRecord(): BaseRecord
}
