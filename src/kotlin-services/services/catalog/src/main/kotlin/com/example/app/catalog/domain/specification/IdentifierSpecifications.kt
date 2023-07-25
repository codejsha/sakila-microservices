package com.example.app.catalog.domain.specification

import com.example.app.catalog.domain.entity.ActorAggregate
import com.example.app.catalog.domain.entity.MovieAggregate
import com.example.shared.domain.specification.CompositeSpecification

class ActorIdentifierSpecification : CompositeSpecification<ActorAggregate>() {
    override fun isSatisfiedBy(candidate: ActorAggregate): Boolean {
        TODO("Not yet implemented")
    }
}

class MovieIdentifierSpecification : CompositeSpecification<MovieAggregate>() {
    override fun isSatisfiedBy(candidate: MovieAggregate): Boolean {
        TODO("Not yet implemented")
    }
}
