package app.whatrushik.events.createEvent.domain.models

import com.yandex.mapkit.geometry.Point

sealed interface CreateEventEvent {
    data object Init : CreateEventEvent

    data object SaveEventClicked : CreateEventEvent
    data object CancelCreationClicked : CreateEventEvent

    data class OnFocusTakenOff(
        val title: String,
        val category: String,
        val description: String,
        val startDate: String,
        val endDate: String,
        val address: Point
    ) : CreateEventEvent
}
