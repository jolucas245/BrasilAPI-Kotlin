package api.brasil.services

import api.brasil.joao.api.brasil.client.ApiClient
import api.brasil.models.DDD
import io.ktor.client.call.*
import io.ktor.http.*

class DDDService(private val apiClient: ApiClient) {
    suspend fun getCities(ddd: Int) : DDD {
        val response = apiClient.get("ddd/v1/$ddd")
        if(response.status == HttpStatusCode.NotFound) {
            throw DDDErrorException("DDD_NOT_FOUND")
        } else if (response.status == HttpStatusCode.InternalServerError) {
            throw DDDErrorException("Todos os serviços de DDD retornaram erro.")
        }
        return response.body()
    }
}

class DDDErrorException(message: String) : RuntimeException(message)