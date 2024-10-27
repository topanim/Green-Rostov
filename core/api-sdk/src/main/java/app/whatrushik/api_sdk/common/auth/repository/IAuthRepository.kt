package app.whatrushik.api_sdk.common.auth.repository

import kotlinx.serialization.Serializable

interface IAuthRepository {
    @Serializable
    data class AuthTokens(
        val accessToken: String,
        val refreshToken: String
    )

    suspend fun setTokens(tokens: AuthTokens)
    suspend fun getTokens(): AuthTokens?

    suspend fun getAccessToken() = getTokens()?.accessToken
    suspend fun getRefreshToken() = getTokens()?.refreshToken
}