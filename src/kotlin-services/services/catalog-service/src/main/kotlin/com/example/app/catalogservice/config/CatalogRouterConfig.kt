package com.example.app.catalogservice.config

import com.example.app.catalogservice.command.web.CatalogCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class CatalogRouterConfig {
    @Bean
    fun route(catalogCommandHandler: CatalogCommandHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .POST("/catalog/actors", catalogCommandHandler::createActor)
            .PUT("/catalog/actors/{actorId}", catalogCommandHandler::updateActorName)
            .DELETE("/catalog/actors/{actorId}", catalogCommandHandler::deleteActor)
            .POST("/catalog/movies", catalogCommandHandler::createMovie)
            .PUT("/catalog/movies/{movieId}", catalogCommandHandler::updateMovie)
            .DELETE("/catalog/movies/{movieId}", catalogCommandHandler::deleteMovie)
            .POST("/catalog/movies/{movieId}/actors", catalogCommandHandler::addMovieActor)
            .DELETE("/catalog/movies/{movieId}/actors/{actorId}", catalogCommandHandler::removeMovieActor)
            .build()
    }
}
