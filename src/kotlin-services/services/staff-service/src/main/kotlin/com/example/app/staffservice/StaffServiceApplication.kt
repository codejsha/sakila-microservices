package com.example.app.staffservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StaffServiceApplication

fun main(args: Array<String>) {
    runApplication<StaffServiceApplication>(*args)
}
