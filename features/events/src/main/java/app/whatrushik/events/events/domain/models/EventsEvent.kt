package app.whatrushik.events.events.domain.models

sealed interface EventsEvent {
    data object Init : EventsEvent
    data object ClickButton : EventsEvent
    data object FetchAllData : EventsEvent
    data class NavigateToDetail(
        val id: Int,
        val title: String,
        val description: String,
        val picture: String,
        val longitude: Double,
        val latitude: Double
    ) : EventsEvent
}
