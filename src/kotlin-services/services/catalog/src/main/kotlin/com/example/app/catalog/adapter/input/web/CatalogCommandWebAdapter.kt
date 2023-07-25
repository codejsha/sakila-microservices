package com.example.app.catalog.adapter.input.web

import com.example.app.catalog.application.usecase.ActorManagementUseCase
import com.example.app.catalog.application.usecase.MovieActorManagementUseCase
import com.example.app.catalog.application.usecase.MovieManagementUseCase
import com.example.app.catalog.domain.dto.*
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration

@Component
@CrossOrigin
class CatalogCommandWebAdapter(
    private val actorManagementUseCase: ActorManagementUseCase,
    private val movieManagementUseCase: MovieManagementUseCase,
    private val movieActorManagementUseCase: MovieActorManagementUseCase
) {
    fun addActor(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(ActorAddRequestDto::class.java)
            .flatMap { requestData -> actorManagementUseCase.addActor(requestData) }
            .flatMap { ServerResponse.created(URI.create("/catalog/actors/${it.actorId}")).build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun updateActorName(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return request.bodyToMono(ActorNameUpdateRequestDto::class.java)
            .flatMap { requestData -> actorManagementUseCase.updateActorName(actorId, requestData) }
            .flatMap { ServerResponse.ok().build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun deleteActor(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return actorManagementUseCase.deleteActor(actorId)
            .then(ServerResponse.noContent().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun addMovie(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(MovieAddRequestDto::class.java)
            .flatMap { requestData -> movieManagementUseCase.addMovie(requestData) }
            .flatMap { ServerResponse.created(URI.create("/catalog/movies/${it.movieId}")).build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun updateMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieUpdateRequestDto::class.java)
            .flatMap { requestData -> movieManagementUseCase.updateMovie(movieId, requestData) }
            .flatMap { ServerResponse.ok().build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun deleteMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return movieManagementUseCase.deleteMovie(movieId)
            .then(ServerResponse.noContent().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun includeActorInMovieActor(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieActorIncludeActorRequestDto::class.java)
            .flatMap { requestData ->
                movieActorManagementUseCase.includeActorInMovieActor(movieId, requestData.actorId)
            }
            .then(ServerResponse.ok().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))

    }

    fun excludeActorInMovieActor(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieActorExcludeActorRequestDto::class.java)
            .flatMap { requestData ->
                movieActorManagementUseCase.excludeActorFromMovieActor(movieId, requestData.actorId)
            }
            .then(ServerResponse.ok().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }
}
