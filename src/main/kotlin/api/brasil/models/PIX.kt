package api.brasil.models;

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable;

@Serializable
data class PIX(
    val ispb: String? = null,
    val nome: String? = null,

    @SerialName("nome_reduzido")
    val nomeReduzido: String? = null,

    @SerialName("modalidade_participacao")
    val modalidadeParticipacao: String? = null,

    @SerialName("tipo_participacao")
    val tipoParticipacao: String? = null,

    @SerialName("inicio_operacao")
    val inicioOperacao: String? = null
)
