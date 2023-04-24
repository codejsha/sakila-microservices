package com.example.app.catalogservice.query.mapper

import com.example.app.catalogservice.api.MovieData
import com.example.app.catalogservice.api.query.MovieEntity
import com.example.app.catalogservice.api.query.MovieResponseData
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MovieMapper {
    fun mapEntityToResponseData(entity: MovieEntity): MovieResponseData
    fun mapEventDataToEntity(movieId: Int, eventData: MovieData): MovieEntity
}
