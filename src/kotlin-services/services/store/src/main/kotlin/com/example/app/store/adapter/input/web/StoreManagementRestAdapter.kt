package com.example.app.store.adapter.input.web

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
@CrossOrigin
class StoreManagementRestAdapter {
    fun addStore(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun updateStore(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun deleteStore(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }
}
