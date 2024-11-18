package api.brasil.joao.api.brasil

import api.brasil.joao.api.brasil.client.ApiClient
import api.brasil.services.*

class BrasilAPI(private val apiClient: ApiClient = ApiClient()) {
    val banks: BankService = BankService(apiClient)
    val cep: CEPService = CEPService(apiClient)
    val ddd: DDDService = DDDService(apiClient)
    val pix: PIXService = PIXService(apiClient)
    val registroBR: RegistroBRService = RegistroBRService(apiClient)
}