package app.whatrsuhik.auth.register.navigation

import app.whatrsuhik.auth.register.presentation.RegisterFeature
import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object RegisterProvider : NavProvider()

val registerRegistry: Registry = {
    register(RegisterFeature::class)
}
