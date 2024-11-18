package api.brasil.models

import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    val ispb: String? = null,
    val name: String? = null,
    val code: Int? = null,
    val fullName: String? = null,
)