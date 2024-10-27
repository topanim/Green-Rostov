package app.whatrushik.domain.impl.isUserAuthorized

import android.util.Log
import app.whatrushik.api_sdk.common.auth.repository.IAuthRepository

class IsUserAuthorisedUseCase(
    private val authRepository: IAuthRepository
) : IIsUserAuthorisedUseCase {
    override suspend fun execute(): Boolean {
        return authRepository.getTokens() != null
                && authRepository.getAccessToken().isNullOrEmpty().not()
                && authRepository.getRefreshToken().isNullOrEmpty().not()
    }
}