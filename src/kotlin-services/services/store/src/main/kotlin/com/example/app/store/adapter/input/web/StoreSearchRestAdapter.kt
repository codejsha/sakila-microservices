package com.example.app.store.adapter.input.web

import com.example.app.store.application.usecase.StoreSearchUseCase
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.time.Duration

@Component
@CrossOrigin
class StoreSearchRestAdapter(
    private val storeSearchUseCase: StoreSearchUseCase
) {
    fun searchStores(request: ServerRequest): Mono<ServerResponse> {
        return request.toMono()
            .flatMap { storeSearchUseCase.findStores() }
            .let { ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(it) }
            .onErrorResume { ServerResponse.badRequest().bodyValue(it.message!!) }
            .timeout(Duration.ofSeconds(10))
    }

    fun searchStoreById(request: ServerRequest): Mono<ServerResponse> {
        val storeId = request.pathVariable("storeId").toInt()
        return request.toMono()
            .flatMap { storeSearchUseCase.findStore(storeId) }
            .flatMap { ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(it, String::class.java) }
            .onErrorResume { ServerResponse.badRequest().bodyValue(it.message!!) }
            .timeout(Duration.ofSeconds(10))
    }
}
