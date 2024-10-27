package app.whatrsuhik.auth.login.data

import app.whatrushik.api_sdk.common.auth.repository.IAuthRepository
import app.whatrushik.api_sdk.common.auth.service.IAuthService
import app.whatrushik.api_sdk.shared.dto.Auth
import app.whatrushik.domain.api.DataUseCase
import kotlinx.serialization.Serializable

internal class LoginUserUseCase(
    private val authService: IAuthService,
    private val authRepository: IAuthRepository
) : DataUseCase<LoginUserUseCase.Data, Result<Unit>> {

    @Serializable
    data class Data(
        val username: String,
        val password: String,
    )

    private fun Data.toAuthParametersLogin() = Auth.Parameters.Login(
        username = username,
        password = password
    )

    override suspend fun execute(
        data: Data
    ): Result<Unit> = try {
        val loginResponse = authService.login(data.toAuthParametersLogin())

        authRepository.setTokens(
            IAuthRepository.AuthTokens(
                accessToken = loginResponse.accessToken,
                refreshToken = loginResponse.refreshToken
            )
        )

        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

}