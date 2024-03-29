package com.example.app.catalog.infrastructure.adapter.input.web

import com.example.app.catalog.application.port.input.*
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
class CatalogManagementRestAdapter(
    private val actorManagementUseCase: ActorManagementUseCase,
    private val movieManagementUseCase: MovieManagementUseCase,
    private val movieActorManagementUseCase: MovieActorManagementUseCase
) {
    fun addActor(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(ActorAddRequestDto::class.java)
            .flatMap { requestData -> actorManagementUseCase.addActor(ActorAddCommand(requestData)) }
            .flatMap { ServerResponse.created(URI.create("/catalog/actors/${it.actorId}")).build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun updateActorName(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return request.bodyToMono(ActorNameUpdateRequestDto::class.java)
            .flatMap { requestData ->
                actorManagementUseCase.updateActorName(ActorNameUpdateCommand(actorId, requestData))
            }
            .flatMap { ServerResponse.ok().build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun deleteActor(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return actorManagementUseCase.deleteActor(ActorDeleteCommand(actorId))
            .then(ServerResponse.noContent().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun addMovie(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(MovieAddRequestDto::class.java)
            .flatMap { requestData ->
                movieManagementUseCase.addMovie(MovieAddCommand(requestData))
            }
            .flatMap { ServerResponse.created(URI.create("/catalog/movies/${it.movieId}")).build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun updateMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieUpdateRequestDto::class.java)
            .flatMap { requestData ->
                movieManagementUseCase.updateMovie(MovieUpdateCommand(movieId, requestData))
            }
            .flatMap { ServerResponse.ok().build() }
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun deleteMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return movieManagementUseCase.deleteMovie(MovieDeleteCommand(movieId))
            .then(ServerResponse.noContent().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun addActorInMovieActor(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(ActorInMovieActorAddRequestDto::class.java)
            .flatMap { requestData ->
                movieActorManagementUseCase.addActorInMovieActor(
                    ActorInMovieActorAddCommand(movieId, requestData.actorId)
                )
            }
            .then(ServerResponse.ok().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }

    fun removeActorInMovieActor(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(ActorInMovieActorRemoveRequestDto::class.java)
            .flatMap { requestData ->
                movieActorManagementUseCase.removeActorInMovieActor(
                    ActorInMovieActorRemoveCommand(movieId, requestData.actorId)
                )
            }
            .then(ServerResponse.ok().build())
            .onErrorResume { ServerResponse.badRequest().build() }
            .timeout(Duration.ofSeconds(10))
    }
}
