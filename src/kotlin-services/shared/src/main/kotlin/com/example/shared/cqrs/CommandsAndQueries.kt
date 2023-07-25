package com.example.shared.cqrs

interface PortCommand

interface PortCommandHandler<C : PortCommand> {
    fun handle(command: C)
}

interface PortQuery<R>

interface PortQueryHandler<Q : PortQuery<R>, R> {
    fun handle(query: Q): R
}
