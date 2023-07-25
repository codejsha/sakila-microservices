package com.example.app.catalog.application.service

import com.example.app.catalog.application.usecase.MovieSearchUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MovieSearchService : MovieSearchUseCase {
    @Transactional(readOnly = true)
    override fun findMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    @Transactional(readOnly = true)
    override fun findMovies() {
        TODO("Not yet implemented")
    }
}
