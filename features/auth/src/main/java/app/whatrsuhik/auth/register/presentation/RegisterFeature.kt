package app.whatrsuhik.auth.register.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.auth.register.domain.RegisterController
import app.whatrsuhik.auth.register.domain.models.RegisterEvent
import app.whatrsuhik.auth.register.navigation.RegisterProvider
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class RegisterFeature(
    override val data: RegisterProvider
) :
    FeatureComponent<RegisterController, RegisterEvent>(),
    NavComponent<RegisterProvider>,
    KoinComponent {
    override val controller: RegisterController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(RegisterEvent.Init)
        }

        RegisterView(state, listener)

        when (action) {
            else -> {}
        }
    }
}
