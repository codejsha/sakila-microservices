package com.example.shared.domain.record

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

open class BaseRecord(
    @Column("create_date") @CreatedDate var createDate: LocalDateTime? = null,
    @Column("last_update") @LastModifiedDate var lastUpdate: LocalDateTime? = null
)
