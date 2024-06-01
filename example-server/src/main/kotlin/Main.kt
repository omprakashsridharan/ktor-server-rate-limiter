package com.omprakash

import com.omprakash.algorithm.fixedwindow.FixedWindow
import com.omprakash.algorithm.fixedwindow.FixedWindowInMemoryStorage
import com.omprakash.plugin.RateLimiterPlugin
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080, // This is the port on which Ktor is listening
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    install(RateLimiterPlugin) {
        algorithm = FixedWindow(maxRequests = 10, storage = FixedWindowInMemoryStorage())
    }
}