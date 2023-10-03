package com.example.shared.cqrs

abstract class CommandPort

interface CommandPortHandler<C : CommandPort> {
    fun handle(command: C) : Any
}
