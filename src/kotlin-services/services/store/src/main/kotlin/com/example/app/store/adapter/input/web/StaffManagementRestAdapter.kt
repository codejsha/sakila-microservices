package com.example.app.store.adapter.input.web

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
@CrossOrigin
class StaffManagementRestAdapter {
    fun addStaff(request: ServerRequest): Mono<ServerResponse> {
        return Mono.error(UnsupportedOperationException("Not yet implemented"))
    }

    fun updateStaff(request: ServerRequest): Mono<ServerResponse> {
        return Mono.error(UnsupportedOperationException("Not yet implemented"))
    }

    fun deleteStaff(request: ServerRequest): Mono<ServerResponse> {
        return Mono.error(UnsupportedOperationException("Not yet implemented"))
    }

    fun assignStaffToStore(request: ServerRequest): Mono<ServerResponse> {
        return Mono.error(UnsupportedOperationException("Not yet implemented"))
    }

    fun unassignStaffFromStore(request: ServerRequest): Mono<ServerResponse> {
        return Mono.error(UnsupportedOperationException("Not yet implemented"))
    }
}
