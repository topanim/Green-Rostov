package app.whatrushik.events.detailEvent.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.core.navigation.core.rememberNavigator
import app.whatrushik.events.detailEvent.domain.DetailEventController
import app.whatrushik.events.detailEvent.domain.models.DetailEventAction
import app.whatrushik.events.detailEvent.domain.models.DetailEventEvent
import app.whatrushik.events.detailEvent.navigation.DetailEventProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DetailEventFeature(
    override val data: DetailEventProvider
) :
    FeatureComponent<DetailEventController, DetailEventEvent>(),
    NavComponent<DetailEventProvider>,
    KoinComponent {
    override val controller: DetailEventController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigator = rememberNavigator()

        LaunchedEffect(Unit) {
            listener(
                DetailEventEvent.Init(
                    data.id,
                    data.title,
                    data.description,
                    data.picture,
                    data.longitude,
                    data.latitude
                )
            )
        }

        DetailEventView(state, listener)

        when (action) {
            DetailEventAction.BackButtonClicked -> {
                controller.clearAction()
                navigator.c.navigateUp()
            }

            null -> {}
        }
    }
}