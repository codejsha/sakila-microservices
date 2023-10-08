package com.example.app.catalog.infrastructure.adapter.input.web

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
@CrossOrigin
class CatalogSearchRestAdapter {
    fun getActor(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun getActorList(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun getMovie(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun getMovieList(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }
}
