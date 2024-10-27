package app.whatrsuhik.auth.login.navigation

import app.whatrsuhik.auth.login.presentation.LoginFeature
import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object LoginProvider : NavProvider()

val loginRegistry: Registry = {
    register(LoginFeature::class)
}
