package app.whatrushik.api_sdk.common.request

import app.whatrushik.api_sdk.common.auth.repository.IAuthRepository
import app.whatrushik.api_sdk.common.auth.service.IAuthService
import app.whatrushik.api_sdk.shared.dto.Auth
import app.whatrushik.api_sdk.shared.protocols.Parametable
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.util.StringValues
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class RequestService(
    private val client: HttpClient,
    private val baseUrl: String,
    private val authRepository: IAuthRepository
) : IRequestService, KoinComponent {

    private val authService: IAuthService by inject()

    override suspend fun makeRequest(
        path: String,
        method: HttpMethod,
        headers: StringValues,
        body: String?,
        parameters: Parametable?
    ): HttpResponse = client.request(baseUrl + path) {
        this.method = method
        headers { appendAll(headers) }

        if (body != null) {
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        parameters?.toStringValues()?.forEach { key, value ->
            parameter(key, value.first())
        }
    }

    override suspend fun makeAuthRequest(
        path: String,
        method: HttpMethod,
        headers: StringValues,
        body: String?,
        parameters: Parametable?
    ): HttpResponse {
        val headersWithAuth = StringValues.build {
            appendAll(headers)
            append("Authorization", "Bearer ${authRepository.getAccessToken()}")
        }

        val response = makeRequest(
            path = path,
            method = method,
            headers = headersWithAuth,
            body = body,
            parameters = parameters
        )

        if (response.status.value != 401) return response

        val refreshedTokens = authService.refresh(
            Auth.Parameters.Refresh(
                refreshToken = authRepository.getRefreshToken()!!
            )
        )

        val headersWithAuthRefreshed = StringValues.build {
            appendAll(headers)
            append("Authorization", "Bearer ${refreshedTokens.accessToken}")
        }

        authRepository.setTokens(
            IAuthRepository.AuthTokens(
                accessToken = refreshedTokens.accessToken,
                refreshToken = refreshedTokens.refreshToken
            )
        )

        return makeRequest(
            path = path,
            method = method,
            headers = headersWithAuthRefreshed,
            body = body,
            parameters = parameters
        )
    }
}
