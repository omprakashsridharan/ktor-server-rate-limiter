/*
 * This source file was generated by the Gradle 'init' task
 */
package com.omprakash.plugin

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.logging.*

internal val LOGGER = KtorSimpleLogger("com.omprakash.RateLimiterPlugin")


val RateLimiterPlugin =
    createApplicationPlugin(name = "rateLimiterPlugin", createConfiguration = ::RateLimiterConfiguration) {
        LOGGER.info("rate limiter plugin installed")
        pluginConfig.apply {
            onCall { call ->
                val requestValidity = algorithm.validateRequest()
                requestValidity.onSuccess {
                    LOGGER.info("request is within rate limit")
                }.onFailure {
                    LOGGER.error("request exceeded rate limit")
                    call.respond(HttpStatusCode.TooManyRequests)
                }
            }
        }
    }
