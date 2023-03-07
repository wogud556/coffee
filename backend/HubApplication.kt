package com.jay.backend.hub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HubApplication

fun main(args: Array<String>) {
	runApplication<HubApplication>(*args)
}
