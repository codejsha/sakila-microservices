package com.example.app.catalog.config

import com.example.app.catalog.adapter.input.web.CatalogManagementRestAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouterFunctionConfig {
    @Bean
    fun routeCatalog(catalogManagementRestAdapter: CatalogManagementRestAdapter): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .POST("/catalog/actors", catalogManagementRestAdapter::addActor)
            .PUT("/catalog/actors/{actorId}", catalogManagementRestAdapter::updateActorName)
            .DELETE("/catalog/actors/{actorId}", catalogManagementRestAdapter::deleteActor)
            .POST("/catalog/movies", catalogManagementRestAdapter::addMovie)
            .PUT("/catalog/movies/{movieId}", catalogManagementRestAdapter::updateMovie)
            .DELETE("/catalog/movies/{movieId}", catalogManagementRestAdapter::deleteMovie)
            .build()
    }
}
