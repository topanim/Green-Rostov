package app.whatrushik.splash.navigation

import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import app.whatrushik.splash.presentation.SplashFeature
import kotlinx.serialization.Serializable

@Serializable
object SplashProvider : NavProvider()

val splashRegistry: Registry = {
    register(SplashFeature::class)
}
