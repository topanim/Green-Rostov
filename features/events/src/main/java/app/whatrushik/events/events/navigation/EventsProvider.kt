package app.whatrushik.events.events.navigation

import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import app.whatrushik.events.events.presentation.EventsFeature
import kotlinx.serialization.Serializable

@Serializable
object EventsProvider : NavProvider()

val eventsRegistry: Registry = {
    register(EventsFeature::class)
}
