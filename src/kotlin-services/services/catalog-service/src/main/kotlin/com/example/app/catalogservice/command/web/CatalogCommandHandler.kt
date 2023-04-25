package com.example.app.catalogservice.command.web

import com.example.app.catalogservice.api.command.*
import com.example.app.catalogservice.repository.CommonRepository
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.net.URI

@Component
@CrossOrigin
class CatalogCommandHandler(
    private val reactiveCommandGateway: ReactorCommandGateway,
    private val commonRepository: CommonRepository
) {
    fun createActor(request: ServerRequest): Mono<ServerResponse> {
        return Mono
            .zip(
                commonRepository.getMaximumValueOfTable("actor", "actor_id").mapNotNull { it!!.plus(1) },
                request.bodyToMono(ActorCreateRequestData::class.java)
                    .log()
            )
            .flatMap { tuple ->
                reactiveCommandGateway.send<Any?>(CreateActorCommand(tuple.t1, tuple.t2))
                    .then(ServerResponse.created(URI.create("/catalog/actors/${tuple.t1}")).build())
                    .onErrorResume { ServerResponse.badRequest().build() }
            }
    }

    fun updateActorName(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return request.bodyToMono(ActorNameUpdateRequestData::class.java)
            .log()
            .flatMap { requestData ->
                reactiveCommandGateway.send<Any?>(UpdateActorNameCommand(actorId, requestData))
                    .then(ServerResponse.ok().build())
                    .onErrorResume { ServerResponse.badRequest().build() }
            }
    }

    fun deleteActor(request: ServerRequest): Mono<ServerResponse> {
        val actorId = request.pathVariable("actorId").toInt()
        return reactiveCommandGateway.send<Any?>(DeleteActorCommand(actorId))
            .then(ServerResponse.noContent().build())
            .onErrorResume { ServerResponse.badRequest().build() }
    }

    fun createMovie(request: ServerRequest): Mono<ServerResponse> {
        return Mono
            .zip(
                commonRepository.getMaximumValueOfTable("sakila.film", "film_id").mapNotNull { it!!.plus(1) },
                request.bodyToMono(MovieCreateRequestData::class.java)
                    .log()
            )
            .flatMap { tuple ->
                reactiveCommandGateway.send<Any?>(CreateMovieCommand(tuple.t1, tuple.t2))
                    .then(ServerResponse.created(URI.create("/catalog/movies/${tuple.t1}")).build())
                    .onErrorResume { ServerResponse.badRequest().build() }
            }
    }

    fun updateMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieUpdateRequestData::class.java)
            .log()
            .flatMap { requestData ->
                reactiveCommandGateway.send<Any?>(UpdateMovieCommand(movieId, requestData))
                    .then(ServerResponse.ok().build())
                    .onErrorResume { ServerResponse.badRequest().build() }
            }
    }

    fun deleteMovie(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return reactiveCommandGateway.send<Any?>(DeleteMovieCommand(movieId))
            .then(ServerResponse.noContent().build())
            .onErrorResume { ServerResponse.badRequest().build() }
    }

    fun addMovieActor(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieAddActorRequestData::class.java)
            .flatMap { requestData ->
                reactiveCommandGateway.send<Any?>(AddMovieActorCommand(movieId, requestData.actorId))
                    .then(ServerResponse.ok().build())
                    .onErrorResume { ServerResponse.badRequest().build() }
            }
    }

    fun removeMovieActor(request: ServerRequest): Mono<ServerResponse> {
        val movieId = request.pathVariable("movieId").toInt()
        return request.bodyToMono(MovieRemoveActorRequestData::class.java)
            .flatMap { requestData ->
                reactiveCommandGateway.send<Any?>(RemoveMovieActorCommand(movieId, requestData.actorId))
                    .then(ServerResponse.ok().build())
                    .onErrorResume { ServerResponse.badRequest().build() }
            }
    }
}
