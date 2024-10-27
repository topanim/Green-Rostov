package app.whatrushik.api_sdk.common.auth.service

import app.whatrushik.api_sdk.shared.dto.Auth

interface IAuthService {
    suspend fun login(
        parameters: Auth.Parameters.Login
    ): Auth.Responses.Login

    suspend fun refresh(
        parameters: Auth.Parameters.Refresh
    ): Auth.Responses.Refresh

    suspend fun register(
        parameters: Auth.Parameters.Register
    ): Auth.Responses.Registered

    suspend fun me(
        parameters: Auth.Parameters.Me
    ): Auth.Responses.Me
}