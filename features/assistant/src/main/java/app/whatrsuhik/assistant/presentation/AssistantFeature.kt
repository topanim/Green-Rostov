package app.whatrsuhik.assistant.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.assistant.domain.AssistantController
import app.whatrsuhik.assistant.domain.models.AssistantEvent
import app.whatrsuhik.assistant.navigation.AssistantProvider
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AssistantFeature(
    override val data: AssistantProvider
) :
    FeatureComponent<AssistantController, AssistantEvent>(),
    NavComponent<AssistantProvider>,
    KoinComponent {
    override val controller: AssistantController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(AssistantEvent.Init)
        }

        AssistantView(state, listener)

        when (action) {
            else -> {}
        }
    }
}
