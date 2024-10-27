package app.whatrushik.main.navigation

import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import app.whatrushik.main.presentation.MainFeature
import kotlinx.serialization.Serializable

@Serializable
object MainProvider : NavProvider()

val mainRegistry: Registry = {
    register(MainFeature::class)
}