package app.whatrsuhik.profile.profile.navigation

import app.whatrsuhik.profile.profile.presentation.ProfileFeature
import app.whatrushik.core.navigation.core.NavProvider
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object ProfileProvider : NavProvider()

val profileRegistry: Registry = {
    register(ProfileFeature::class)
}
