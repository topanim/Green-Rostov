package app.whatrushik.main.children.expenses.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrushik.main.children.expenses.domain.models.ExpensesEvent
import app.whatrushik.main.children.expenses.domain.models.ExpensesState

@Composable
fun ExpensesView(
    state: ExpensesState,
    listener: Listener<ExpensesEvent>
) = Column(
    modifier = Modifier.fillMaxSize()
) {

}
