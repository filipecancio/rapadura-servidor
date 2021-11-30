package dev.cancio.models

import kotlinx.serialization.Serializable

@Serializable
data class Debt(
    val id: String,
    val name: String,
    val value: Double,
    val type: Int,
    val description: String
)

val debtStorage = mutableListOf<Debt>()