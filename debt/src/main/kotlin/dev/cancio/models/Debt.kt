package dev.cancio.models

import dev.cancio.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Debt(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val value: Double,
    val type: Int,
    val description: String
)

val debtStorage = mutableListOf<Debt>()