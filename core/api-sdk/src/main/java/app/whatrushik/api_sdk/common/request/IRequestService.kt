package app.whatrushik.api_sdk.common.request

import app.whatrushik.api_sdk.shared.protocols.Parametable
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.util.StringValues

interface IRequestService {
    suspend fun makeRequest(
        path: String,
        method: HttpMethod = HttpMethod.Get,
        headers: StringValues = StringValues.Empty,
        body: String? = null,
        parameters: Parametable? = null
    ): HttpResponse

    suspend fun makeAuthRequest(
        path: String,
        method: HttpMethod = HttpMethod.Get,
        headers: StringValues = StringValues.Empty,
        body: String? = null,
        parameters: Parametable? = null
    ): HttpResponse
}