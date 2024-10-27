package app.whatrushik.api_sdk.api.ecology

import app.whatrushik.api_sdk.shared.dto.Ecology

interface IEcologyService {
    suspend fun getUV(
        data: Ecology.Parameters.Get
    ): Ecology.Responses.UV
}