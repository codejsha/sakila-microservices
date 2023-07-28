package com.example.shared.cqrs

interface QueryPort<R>

interface QueryPortHandler<Q : QueryPort<R>, R> {
    fun handle(query: Q): R
}
