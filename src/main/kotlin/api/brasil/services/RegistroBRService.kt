package api.brasil.services

import api.brasil.joao.api.brasil.client.ApiClient
import api.brasil.models.RegistroBR
import io.ktor.client.call.*
import io.ktor.http.*

class RegistroBRService(private val apiClient: ApiClient) {

    suspend fun getDomainInfo(domain: String) : RegistroBR {
        val response = apiClient.get("registrobr/v1/$domain")
        if(response.status == HttpStatusCode.BadRequest) {
            throw RegistroBRErrorException("BAD_REQUEST: O domínio não foi informado corretamente!")
        }
        return response.body()
    }
}

class RegistroBRErrorException(message: String?) : RuntimeException(message)