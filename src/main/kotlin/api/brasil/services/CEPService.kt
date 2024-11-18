package api.brasil.services

import api.brasil.joao.api.brasil.client.ApiClient
import api.brasil.models.CEP
import io.ktor.client.call.*
import io.ktor.http.*

class CEPService(private val apiClient: ApiClient) {
    suspend fun searchCEP(cep: String) : CEP {
        val response = apiClient.get("cep/v1/$cep")
        if (response.status == HttpStatusCode.BadRequest) {
            throw CEPErrorException("CEP deve conter exatamente 8 caracteres.")
        }else if (response.status == HttpStatusCode.NotFound) {
            throw CEPErrorException("Todos os serviços de CEP retornaram erro.")
        }
        return response.body()
    }
}

class CEPErrorException(message: String) : RuntimeException(message)
