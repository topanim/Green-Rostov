package app.whatrushik.api_sdk.common.auth.service

import app.whatrushik.api_sdk.common.request.IRequestService
import app.whatrushik.api_sdk.shared.dto.Auth
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class AuthService(
    private val requestService: IRequestService,
    private val coder: Json
) : IAuthService {

    override suspend fun login(
        parameters: Auth.Parameters.Login
    ) = requestService.makeRequest(
        path = "user/auth/login",
        method = HttpMethod.Post,
        body = coder.encodeToString(parameters)
    ).body<Auth.Responses.Login>()

    override suspend fun refresh(
        parameters: Auth.Parameters.Refresh
    ) = requestService.makeRequest(
        path = "user/auth/refresh",
        method = HttpMethod.Post,
        parameters = parameters
    ).body<Auth.Responses.Refresh>()

    override suspend fun register(
        parameters: Auth.Parameters.Register
    ) = requestService.makeRequest(
        path = "user/auth/register",
        method = HttpMethod.Post,
        body = coder.encodeToString(parameters)
    ).body<Auth.Responses.Registered>()

    override suspend fun me(
        parameters: Auth.Parameters.Me
    ) = requestService.makeRequest(
        path = "user/auth/me",
        method = HttpMethod.Get,
        body = coder.encodeToString(parameters)
    ).body<Auth.Responses.Me>()
}