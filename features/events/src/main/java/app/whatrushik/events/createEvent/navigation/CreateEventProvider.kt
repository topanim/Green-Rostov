package app.whatrushik.events.createEvent.navigation

import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import app.whatrushik.events.createEvent.presentation.CreateEventFeature
import kotlinx.serialization.Serializable

@Serializable
object CreateEventProvider : NavProvider()

val createEventRegistry: Registry = {
    register(CreateEventFeature::class)
}
