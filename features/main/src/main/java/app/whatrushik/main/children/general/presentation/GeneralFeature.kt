package app.whatrushik.main.children.general.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.core.navigation.core.rememberNavigator
import app.whatrushik.core.navigation.utils.orThrow
import app.whatrushik.events.detailEvent.navigation.DetailEventProvider
import app.whatrushik.main.children.general.domain.GeneralController
import app.whatrushik.main.children.general.domain.models.GeneralAction
import app.whatrushik.main.children.general.domain.models.GeneralEvent
import app.whatrushik.main.children.general.navigation.GeneralProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GeneralFeature(
    override val data: GeneralProvider
) :
    FeatureComponent<GeneralController, GeneralEvent>(),
    NavComponent<GeneralProvider>,
    KoinComponent {
    override val controller: GeneralController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        val navigator = rememberNavigator().parent.orThrow

        LaunchedEffect(Unit) {
            listener(GeneralEvent.Init)
        }

        GeneralView(state = state, listener)

        when (action) {
            null -> Unit

            is GeneralAction.NavigateToEventDetail -> {
                val actionState = action as GeneralAction.NavigateToEventDetail
                controller.clearAction()
                navigator.c.navigate(
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
