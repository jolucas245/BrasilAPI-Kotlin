package api.brasil.services

import api.brasil.joao.api.brasil.client.ApiClient
import api.brasil.models.Bank
import io.ktor.client.call.*
import io.ktor.http.*

class BankService(private val apiClient: ApiClient) {
    suspend fun getAllBanks(): List<Bank> {
        return apiClient.get("banks/v1").body()
    }

    suspend fun getBankByCode(code: Int): Bank {
        val response = apiClient.get("banks/v1/$code")
        if (response.status == HttpStatusCode.NotFound) {
            throw BankNotFoundException("BANK_CODE_NOT_FOUND (code: $code)")
        }
        return response.body()
    }
}
class BankNotFoundException(message: String) : RuntimeException(message)
