package dev.cancio

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.cancio.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        configureSerialization()
        configureHTTP()
    }.start(wait = true)
}
