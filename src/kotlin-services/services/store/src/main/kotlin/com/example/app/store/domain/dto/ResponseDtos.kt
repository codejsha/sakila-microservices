package com.example.app.store.domain.dto

data class StoreResponseDto(
    val id: Int,
    val managerStaffName: String,
    val address: String
)

data class StaffResponseDto(
    val id: Int,
    val staffName: String,
    val address: String,
    val storeId: Int,
    val active: Boolean,
    val username: String
)
