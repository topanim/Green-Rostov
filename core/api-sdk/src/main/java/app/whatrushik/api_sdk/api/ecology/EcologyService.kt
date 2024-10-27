package app.whatrushik.api_sdk.api.ecology

import app.whatrushik.api_sdk.common.request.IRequestService
import app.whatrushik.api_sdk.shared.dto.Ecology
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json

internal class EcologyService(
    private val requestService: IRequestService,
    private val coder: Json
) : IEcologyService {
    override suspend fun getUV(
        data: Ecology.Parameters.Get
    ): Ecology.Responses.UV = requestService.makeAuthRequest(
        path = "ecologi/uv",
        method = HttpMethod.Post
    ).body()
}