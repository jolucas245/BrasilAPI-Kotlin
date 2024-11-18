package api.brasil.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistroBR (
    @SerialName("status_code")
    val statusCode: Long? = null,

    val status: String? = null,
    val fqdn: String? = null,
    val fqdnace: String? = null,
    val hosts: List<String>? = null,
    val exempt: Boolean? = null,

    @SerialName("publication-status")
    val publicationStatus: String? = null,

    @SerialName("expires-at")
    val expiresAt: String? = null,

    val suggestions: List<String>? = null
)