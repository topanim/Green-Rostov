package app.whatrushik.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.assistant.navigation.assistantRegistry
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrsuhik.profile.profile.navigation.profileRegistry
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.core.navigation.core.Registry
import app.whatrushik.core.navigation.core.register
import app.whatrushik.events.events.navigation.eventsRegistry
import app.whatrushik.main.children.expenses.presentation.ExpensesFeature
import app.whatrushik.main.children.general.presentation.GeneralFeature
import app.whatrushik.main.domain.MainScreenViewModel
import app.whatrushik.main.domain.model.MainScreenEvent
import app.whatrushik.main.navigation.MainProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


internal class MainFeature(
    override val data: MainProvider
) :
    FeatureComponent<MainScreenViewModel, MainScreenEvent>(),
    NavComponent<MainProvider>,
    KoinComponent {
    override val controller: MainScreenViewModel by inject()

    internal companion object {
        val mainChildrenRegistry: Registry = {
            register(GeneralFeature::class)
            register(ExpensesFeature::class)
            assistantRegistry()
            profileRegistry()
            eventsRegistry()
        }
    }

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        MainView(state, listener)
    }
}