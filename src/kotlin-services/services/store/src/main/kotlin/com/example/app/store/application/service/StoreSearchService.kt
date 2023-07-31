package com.example.app.store.application.service

import com.example.app.store.application.usecase.StoreSearchUseCase
import com.example.app.store.domain.dto.StoreResponseDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class StoreSearchService : StoreSearchUseCase {
    override fun findStore(storeId: Int): Mono<StoreResponseDto> {
        return Mono.empty()
    }

    override fun findStores(): Mono<StoreResponseDto> {
        TODO("Not yet implemented")
    }
}
