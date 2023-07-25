package com.example.app.catalog.config

import com.example.app.catalog.adapter.input.web.CatalogCommandWebAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class CatalogRouterConfig {
    @Bean
    fun route(catalogCommandWebAdapter: CatalogCommandWebAdapter): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .POST("/catalog/actors", catalogCommandWebAdapter::addActor)
            .PUT("/catalog/actors/{actorId}", catalogCommandWebAdapter::updateActorName)
            .DELETE("/catalog/actors/{actorId}", catalogCommandWebAdapter::deleteActor)
            .POST("/catalog/movies", catalogCommandWebAdapter::addMovie)
            .PUT("/catalog/movies/{movieId}", catalogCommandWebAdapter::updateMovie)
            .DELETE("/catalog/movies/{movieId}", catalogCommandWebAdapter::deleteMovie)
            .build()
    }
}
