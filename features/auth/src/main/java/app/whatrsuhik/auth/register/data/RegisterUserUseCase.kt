package app.whatrsuhik.auth.register.data

import app.whatrsuhik.auth.login.data.LoginUserUseCase
import app.whatrushik.api_sdk.common.auth.service.IAuthService
import app.whatrushik.api_sdk.shared.dto.Auth
import app.whatrushik.domain.api.DataUseCase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal class RegisterUserUseCase(
    private val authService: IAuthService,
    private val loginUserUseCase: LoginUserUseCase
) : DataUseCase<RegisterUserUseCase.Data, Result<Unit>> {

    @Serializable
    data class Data(
        val username: String,
        val password: String,
        @SerialName("first_name") val firstName: String,
        @SerialName("last_name") val lastName: String,
        val patronymic: String,
        @SerialName("british_date") val britishDate: String
    )

    private fun Data.toAuthParametersRegister() = Auth.Parameters.Register(
        username = username,
        password = password,
        firstName = firstName,
        lastName = lastName,
        patronymic = patronymic,
        britishDate = "2024-10-26T08:17:09.321Z"
    )

    override suspend fun execute(
        data: Data
    ): Result<Unit> = try {
        authService.register(data.toAuthParametersRegister())
        val loginResult =
            loginUserUseCase.execute(LoginUserUseCase.Data(data.username, data.password))

        if (loginResult.isSuccess) Result.success(Unit)
        else Result.failure(loginResult.exceptionOrNull()!!)
    } catch (e: Exception) {
        Result.failure(e)
    }
}