package com.example.shared.cqrs

abstract class QueryPort<R>

interface QueryPortHandler<Q : QueryPort<R>, R> {
    fun handle(query: Q): R
}
