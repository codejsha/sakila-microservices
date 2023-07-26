package com.example.shared.cqrs

interface CommandPort

interface CommandPortHandler<C : CommandPort> {
    fun handle(command: C)
}

interface QueryPort<R>

interface QueryPortHandler<Q : QueryPort<R>, R> {
    fun handle(query: Q): R
}
