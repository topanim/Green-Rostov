package app.whatrushik.events.events.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.core.navigation.core.rememberNavigator
import app.whatrushik.core.navigation.utils.orThrow
import app.whatrushik.events.createEvent.navigation.CreateEventProvider
import app.whatrushik.events.detailEvent.navigation.DetailEventProvider
import app.whatrushik.events.events.domain.EventsController
import app.whatrushik.events.events.domain.models.EventsAction
import app.whatrushik.events.events.domain.models.EventsEvent
import app.whatrushik.events.events.navigation.EventsProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class EventsFeature(
    override val data: EventsProvider
) :
    FeatureComponent<EventsController, EventsEvent>(),
    NavComponent<EventsProvider>,
    KoinComponent {
    override val controller: EventsController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        val parentNavigator = rememberNavigator().parent.orThrow

        LaunchedEffect(Unit) {
            listener(EventsEvent.FetchAllData)
        }

        EventsView(state, listener)

        when (action) {
            null -> Unit

            EventsAction.NavigateToCreate -> {
                controller.clearAction()
                parentNavigator.c.navigate(CreateEventProvider)
            }

            is EventsAction.NavigateToDetail -> {
                val actionState = action as EventsAction.NavigateToDetail
                controller.clearAction()
                parentNavigator.c.navigate(
                    DetailEventProvider(
                        actionState.id,
                        actionState.title,
                        actionState.description,
                        actionState.picture,
                        actionState.longitude,
                        actionState.latitude
                    )
                )
            }
        }
    }
}
