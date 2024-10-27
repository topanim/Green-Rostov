package app.whatrushik.main.children.expenses.domain.models

sealed interface ExpensesEvent {
    data object Init : ExpensesEvent
}
