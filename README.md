# sakila-microservices

Sakila REST API Microservices (Sample Project)

![Gradle Build](https://github.com/codejsha/sakila-microservices/actions/workflows/gradle.yml/badge.svg)

[English](README.md) | [Korean](README_ko-KR.md)

This project provides rental operations for the Sakila DVD Rental Store using microservices architecture. It's based on the Sakila sample database and serves as a learning resource.

Monolith version is go to: https://github.com/codejsha/spring-rest-sakila

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Libraries and Plugins](#libraries-and-plugins)
- [Architecture](#architecture)
- [Roadmap](#roadmap)
- [Sample Data](#sample-data)
- [References](#references)

## Getting Started

### Requirements

- Kotlin 1.8
- Java 17
- Gradle 8
- MySQL 8
- Apache Kafka 3
- MongoDB 6

### Libraries and Plugins

For a complete list, see the `gradle/libs.versions.toml` file.

- Spring WebFlux
- Spring Data R2DBC
- Axon Framework
- MapStruct

## Architecture

The following diagram shows the architecture of the Sakila DVD Rental Store. The diagram is based on the [C4 model](https://c4model.com/).

```mermaid
C4Container
    title Architecture Diagram for Sakila DVD Rental Store

    Person(manager, "Manager")

    System_Boundary(sakila, "Sakila System") {
        Container(catalogService, "Catalog Service")
        ContainerDb(catalogDb, "Catalog Database", "MySQL")
        Container(customerService, "Customer Service")
        ContainerDb(customerDb, "Customer Database", "MySQL")
        Container(paymentService, "Payment Service")
        ContainerDb(paymentDb, "Payment Database", "MySQL")
        Container(rentalService, "Rental Service")
        ContainerDb(rentalDb, "Rental Database", "MySQL")
        Container(staffService, "Staff Service")
        ContainerDb(staffDb, "Staff Database", "MySQL")
        Container(storeService, "Store Service")
        ContainerDb(storeDb, "Store Database", "MySQL")
        Container(locationService, "Location Service")
        ContainerDb(locationDb, "Location Database", "MySQL")
    }


    Rel(manager, catalogService, "manages")
    Rel(manager, customerService, "manages")
    Rel(manager, rentalService, "manages")
    Rel(manager, paymentService, "manages")
    Rel(manager, storeService, "manages")

    Rel(catalogService, catalogDb, "read/write")

    Rel(customerService, locationService, "uses")
    BiRel(customerService, paymentService, "uses")
    BiRel(customerService, rentalService, "uses")
    BiRel(customerService, storeService, "uses")
    Rel(customerService, customerDb, "read/write")

    BiRel(locationService, staffService, "uses")
    BiRel(locationService, storeService, "uses")
    Rel(locationService, locationDb, "read/write")

    BiRel(paymentService, rentalService, "uses")
    BiRel(paymentService, staffService, "uses")
    Rel(paymentService, paymentDb, "read/write")

    BiRel(rentalService, staffService, "uses")
    Rel(rentalService, rentalDb, "read/write")

    BiRel(staffService, storeService, "uses")
    Rel(staffService, staffDb, "read/write")

    Rel(storeService, catalogService, "uses")
    Rel(storeService, storeDb, "read/write")

    UpdateLayoutConfig($c4ShapeInRow="4")
```

## Roadmap

- [ ] Implement all services
- [ ] Add tests for REST Docs and OpenAPI spec
- [ ] Add HATEOAS
- [ ] Add Netflix Conductor for orchestration
- [ ] Add Helm charts for each service
- [ ] Add Tekton CI/CD pipeline
- [ ] Add Argo CD resources for GitOps
- [ ] Add Istio service mesh
- [ ] Add ServiceMonitor and PrometheusRule for monitoring
- [ ] Add security

## Sample Data

The sample data comes from the Sakila sample database by MySQL and is intended for learning and testing purposes. It features a relational database model for a DVD rental store company that contains data related to films, actors, customers, rentals, and more.

## References

- [MySQL Sakila sample database](https://dev.mysql.com/doc/sakila/en/)
