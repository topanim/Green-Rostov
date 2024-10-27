package app.whatrushik.main.children.expenses.domain

import app.whatrsuhik.core.foundation.core.UIController
import app.whatrushik.main.children.expenses.domain.models.ExpensesAction
import app.whatrushik.main.children.expenses.domain.models.ExpensesEvent
import app.whatrushik.main.children.expenses.domain.models.ExpensesState

class ExpensesController : UIController<ExpensesState, ExpensesAction, ExpensesEvent>(
    ExpensesState()
) {
    override fun obtainEvent(viewEvent: ExpensesEvent) = when (viewEvent) {
        ExpensesEvent.Init -> {}
    }
}
