package app.whatrushik.main.children.expenses.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.main.children.expenses.domain.ExpensesController
import app.whatrushik.main.children.expenses.domain.models.ExpensesEvent
import app.whatrushik.main.children.expenses.navigation.ExpensesProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ExpensesFeature(
    override val data: ExpensesProvider
) :
    FeatureComponent<ExpensesController, ExpensesEvent>(),
    NavComponent<ExpensesProvider>,
    KoinComponent {
    override val controller: ExpensesController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(ExpensesEvent.Init)
        }

        ExpensesView(state, listener)

        when (action) {
            else -> {}
        }
    }
}
