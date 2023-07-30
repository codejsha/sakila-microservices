package com.example.app.store.domain.entity

import java.time.LocalDate

data class StaffAggregate(
    var staffId: Int,
    var firstName: String,
    var lastName: String,
    var addressId: Int,
    var storeId: Int,
    var active: Boolean,
    var username: String,
    var authorityId: Int,
    var createDate: LocalDate
)
