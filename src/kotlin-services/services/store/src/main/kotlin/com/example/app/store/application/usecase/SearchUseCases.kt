package com.example.app.store.application.usecase

import com.example.app.store.domain.dto.StaffResponseDto
import com.example.app.store.domain.dto.StoreResponseDto
import reactor.core.publisher.Mono

interface StoreSearchUseCase {
    fun findStore(storeId: Int): Mono<StoreResponseDto>
    fun findStores(): Mono<StoreResponseDto>
}

interface StaffSearchUseCase {
    fun findStaff(staffId: Int): Mono<StaffResponseDto>
    fun findStaffs(): Mono<StaffResponseDto>
}
