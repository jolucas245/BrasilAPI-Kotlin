package api.brasil.models

import kotlinx.serialization.Serializable

@Serializable
data class DDD (
    val state: String,
    val cities: List<String>
)
