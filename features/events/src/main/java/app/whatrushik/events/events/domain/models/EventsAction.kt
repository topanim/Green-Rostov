package app.whatrushik.events.events.domain.models

sealed interface EventsAction {
    data object NavigateToCreate : EventsAction
    data class NavigateToDetail(
        val id: Int,
        val title: String,
        val description: String,
        val picture: String,
        val longitude: Double,
        val latitude: Double
    ) : EventsAction
}
