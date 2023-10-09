package com.example.app.catalog.infrastructure.adapter.input.web

import com.example.app.catalog.application.port.input.ActorGetQuery
import com.example.app.catalog.application.port.input.ActorListGetQuery
import com.example.app.catalog.application.port.input.MovieGetQuery
import com.example.app.catalog.application.port.input.MovieListGetQuery
import com.example.app.catalog.application.usecase.ActorSearchUseCase
import com.example.app.catalog.application.usecase.MovieSearchUseCase
import com.example.shared.infrastructure.adapter.web.ElementRequest
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.Duration

@Component
@CrossOrigin
class CatalogSearchRestAdapter(
    private val actorSearchUseCase: ActorSearchUseCase,
    private val movieSearchUseCase: MovieSearchUseCase
) {
    fun getActor(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return actorSearchUseCase.findActor(ActorGetQuery(actorId))
            .flatMap { ServerResponse.ok().bodyValue(it) }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun getActorList(request: ServerRequest): Mono<ServerResponse> {
        val page = request.queryParam("page").orElse("1").toInt()
        val size = request.queryParam("size").orElse("10").toLong()
        return actorSearchUseCase.findActors(ActorListGetQuery(ElementRequest(page, size)))
            .flatMap { ServerResponse.ok().bodyValue(it) }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun getMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return movieSearchUseCase.findMovie(MovieGetQuery(movieId))
            .flatMap { ServerResponse.ok().bodyValue(it) }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun getMovieList(request: ServerRequest): Mono<ServerResponse> {
        val page = request.queryParam("page").orElse("1").toInt()
        val size = request.queryParam("size").orElse("10").toLong()
        return movieSearchUseCase.findMovies(MovieListGetQuery(ElementRequest(page, size)))
            .flatMap { ServerResponse.ok().bodyValue(it) }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }
}
