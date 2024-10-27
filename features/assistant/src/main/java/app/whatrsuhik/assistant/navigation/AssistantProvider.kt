package app.whatrsuhik.assistant.navigation

import app.whatrsuhik.assistant.presentation.AssistantFeature
import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object AssistantProvider : NavProvider()

val assistantRegistry: Registry = {
    register(AssistantFeature::class)
}


