package dev.cancio.plugins

import dev.cancio.routes.debtRoute
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        debtRoute()
    }
}
