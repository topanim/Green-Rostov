package app.whatrsuhik.profile.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrsuhik.profile.profile.domain.ProfileController
import app.whatrsuhik.profile.profile.domain.models.ProfileEvent
import app.whatrsuhik.profile.profile.navigation.ProfileProvider
import app.whatrushik.core.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileFeature(
    override val data: ProfileProvider
) :
    FeatureComponent<ProfileController, ProfileEvent>(),
    NavComponent<ProfileProvider>,
    KoinComponent {
    override val controller: ProfileController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(ProfileEvent.MyActivity)
        }


        ProfileView(state, listener)

        when (action) {
            else -> {}
        }
    }
}
