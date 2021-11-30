package dev.cancio.routes

import dev.cancio.models.Debt
import dev.cancio.models.debtStorage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*

fun Route.debtRoute(){
    route("/debt"){
        get {
            if (debtStorage.isNotEmpty()) {
                call.respond(debtStorage)
            } else {
                call.respondText("No Debts found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val idUuid = UUID.fromString(id)
            val debt = debtStorage.find { it.id == idUuid } ?: return@get call.respondText(
                "No Debt with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(debt)
        }
        post {
            val debt = call.receive<Debt>()
            debtStorage.add(debt)
            call.respondText("Debt stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            val idUuid = UUID.fromString(id)
            if (debtStorage.removeIf { it.id == idUuid }) {
                call.respondText("Debt removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}