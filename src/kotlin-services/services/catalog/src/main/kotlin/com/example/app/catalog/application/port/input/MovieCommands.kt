package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.MovieRequestDto
import com.example.shared.cqrs.CommandPort

interface AddMovieCommand : CommandPort {
    fun execute(id: Int, movieRequestDto: MovieRequestDto)
}

interface UpdateMovieCommand : CommandPort {
    fun execute(id: Int, movieRequestDto: MovieRequestDto)
}

interface DeleteMovieCommand : CommandPort {
    fun execute(id: Int)
}
