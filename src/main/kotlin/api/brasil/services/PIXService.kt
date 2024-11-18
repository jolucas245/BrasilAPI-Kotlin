package api.brasil.services

import api.brasil.joao.api.brasil.client.ApiClient
import api.brasil.models.PIX
import io.ktor.client.call.*
import io.ktor.http.*

class PIXService(private val apiClient: ApiClient) {

    suspend fun participants() : List<PIX> {
        val response = apiClient.get("pix/v1/participants")
        if(response.status == HttpStatusCode.InternalServerError) {
            throw PIXErrorException("PIX_LIST_ERROR: Erro ao obter as informações do BCB.")
        }
        return response.body()
    }

}

class PIXErrorException(message: String) : RuntimeException(message)