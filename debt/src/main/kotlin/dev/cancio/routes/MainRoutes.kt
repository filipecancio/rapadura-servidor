package dev.cancio.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.mainRoute(){
    get("/") {
        call.respondText("Rapadura")
    }
}