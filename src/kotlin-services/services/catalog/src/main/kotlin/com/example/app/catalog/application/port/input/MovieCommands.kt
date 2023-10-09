package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.MovieAddRequestDto
import com.example.app.catalog.domain.dto.MovieUpdateRequestDto
import com.example.shared.application.port.BaseCommand

data class MovieAddCommand(val movieAddRequestDto: MovieAddRequestDto) : BaseCommand()
data class MovieUpdateCommand(val id: Int, val movieUpdateRequestDto: MovieUpdateRequestDto) : BaseCommand()
data class MovieDeleteCommand(val id: Int) : BaseCommand()
