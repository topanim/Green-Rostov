package app.whatrushik.events.detailEvent.navigation

import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import app.whatrushik.events.detailEvent.presentation.DetailEventFeature
import kotlinx.serialization.Serializable

@Serializable
data class DetailEventProvider(
    val id: Int,
    val title: String,
    val description: String,
    val picture: String,
    val longitude: Double,
    val latitude: Double
) : NavProvider()

val detailEventRegistry: Registry = {
    register(DetailEventFeature::class)
}