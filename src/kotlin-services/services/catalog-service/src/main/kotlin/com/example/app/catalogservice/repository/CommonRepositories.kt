package com.example.app.catalogservice.repository

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

interface CommonRepository {
    fun getMaximumValueOfTable(table: String, column: String): Mono<Int?>
}

@Repository
class CommonRepositoryImpl(private val entityTemplate: R2dbcEntityTemplate) : CommonRepository {
    override fun getMaximumValueOfTable(table: String, column: String): Mono<Int?> {
        val sql = "SELECT MAX($column) as MAXIMUM_VALUE FROM $table"
        return entityTemplate.databaseClient.sql(sql)
            .map { row -> row.get("MAXIMUM_VALUE", Int::class.javaObjectType) }
            .first()
            .subscribeOn(Schedulers.boundedElastic())
    }
}
