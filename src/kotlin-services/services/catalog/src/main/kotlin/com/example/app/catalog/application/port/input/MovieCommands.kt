package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.shared.cqrs.CommandPort

interface AddMovieCommand : CommandPort {
    fun execute(id: Int, movieAddRequestDto: MovieAddRequestDto)
}

interface UpdateMovieCommand : CommandPort {
    fun execute(id: Int, movieUpdateRequestDto: MovieUpdateRequestDto)
}

interface DeleteMovieCommand : CommandPort {
    fun execute(id: Int)
}
