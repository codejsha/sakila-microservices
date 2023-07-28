package com.example.app.catalog.adapter.input.web

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
@CrossOrigin
class CatalogSearchRestAdapter {
    fun getActor(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun getActorList(request: ServerRequest): Flux<ServerResponse> {
        return Flux.empty()
    }

    fun getMovie(request: ServerRequest): Mono<ServerResponse> {
        return Mono.empty()
    }

    fun getMovieList(request: ServerRequest): Flux<ServerResponse> {
        return Flux.empty()
    }
}
