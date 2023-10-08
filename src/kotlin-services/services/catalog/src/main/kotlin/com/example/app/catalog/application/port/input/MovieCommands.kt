package com.example.app.catalog.application.port.input

import com.example.app.catalog.domain.dto.MovieRequestDto
import com.example.shared.cqrs.CommandPort

data class MovieAddCommand(val movieRequestDto: MovieRequestDto) : CommandPort()
data class MovieUpdateCommand(val id: Int, val movieRequestDto: MovieRequestDto) : CommandPort()
data class MovieDeleteCommand(val id: Int) : CommandPort()
