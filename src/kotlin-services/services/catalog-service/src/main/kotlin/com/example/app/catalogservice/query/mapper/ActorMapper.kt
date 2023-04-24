package com.example.app.catalogservice.query.mapper

import com.example.app.catalogservice.api.ActorData
import com.example.app.catalogservice.api.query.ActorEntity
import com.example.app.catalogservice.api.query.ActorResponseData
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ActorMapper {
    fun mapEntityToResponseData(entity: ActorEntity): ActorResponseData
    fun mapEventDataToEntity(actorId: Int, eventData: ActorData): ActorEntity
}
