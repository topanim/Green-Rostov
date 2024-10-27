package app.whatrushik.events.createEvent.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.events.createEvent.domain.CreateEventController
import app.whatrushik.events.createEvent.domain.models.CreateEventEvent
import app.whatrushik.events.createEvent.navigation.CreateEventProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateEventFeature(
    override val data: CreateEventProvider
) :
    FeatureComponent<CreateEventController, CreateEventEvent>(),
    NavComponent<CreateEventProvider>,
    KoinComponent {
    override val controller: CreateEventController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(CreateEventEvent.Init)
        }

        CreateEventView(state, listener)

        when (action) {
            else -> {}
        }
    }
}
