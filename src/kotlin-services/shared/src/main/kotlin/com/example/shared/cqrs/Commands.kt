package com.example.shared.cqrs

interface CommandPort

interface CommandPortHandler<C : CommandPort> {
    fun handle(command: C)
}
