package app.whatrushik.main.domain.model

sealed interface MainScreenEvent {
    data class OnSelectFilter(val index: Int) : MainScreenEvent
    data class SearchField(val text: String) : MainScreenEvent
}