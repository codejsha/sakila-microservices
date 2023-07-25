package com.example.shared.domain.specification

interface Specification<T> {
    fun isSatisfiedBy(candidate: T): Boolean
    fun and(other: Specification<T>): Specification<T>
    fun or(other: Specification<T>): Specification<T>
    fun not(): Specification<T>
}

abstract class CompositeSpecification<T> : Specification<T> {
    override fun and(other: Specification<T>): Specification<T> {
        return AndSpecification(this, other)
    }

    override fun or(other: Specification<T>): Specification<T> {
        return OrSpecification(this, other)
    }

    override fun not(): Specification<T> {
        return NotSpecification(this)
    }
}

class AndSpecification<T>(
    private val one: Specification<T>,
    private val other: Specification<T>
) : CompositeSpecification<T>() {
    override fun isSatisfiedBy(candidate: T): Boolean {
        return one.isSatisfiedBy(candidate) && other.isSatisfiedBy(candidate)
    }
}

class OrSpecification<T>(
    private val one: Specification<T>,
    private val other: Specification<T>
) : CompositeSpecification<T>() {
    override fun isSatisfiedBy(candidate: T): Boolean {
        return one.isSatisfiedBy(candidate) || other.isSatisfiedBy(candidate)
    }
}

class NotSpecification<T>(
    private val wrapped: Specification<T>
) : CompositeSpecification<T>() {
    override fun isSatisfiedBy(candidate: T): Boolean {
        return !wrapped.isSatisfiedBy(candidate)
    }
}
