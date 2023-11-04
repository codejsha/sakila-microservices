package com.example.app.catalog.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories(basePackages = ["com.example.app.catalog.infrastructure.adapter.output.database"])
@EnableR2dbcAuditing
class R2dbcConfig {
    @Bean
    fun r2dbcEntityTemplate(connectionFactory: ConnectionFactory): R2dbcEntityTemplate {
        return R2dbcEntityTemplate(connectionFactory)
    }
}
