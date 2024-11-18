package api.brasil.models

import kotlinx.serialization.Serializable

@Serializable
data class CEP(
    val cep: String,
    val state: String,
    val city: String? = null,
    val neighborhood: String? = null,
    val street: String? = null,
    val service: String
)