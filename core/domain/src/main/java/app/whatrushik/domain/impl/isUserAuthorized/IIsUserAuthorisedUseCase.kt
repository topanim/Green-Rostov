package app.whatrushik.domain.impl.isUserAuthorized

import app.whatrushik.api_sdk.common.auth.repository.IAuthRepository
import app.whatrushik.domain.api.UseCase

interface IIsUserAuthorisedUseCase: UseCase<Boolean>