package app.whatrushik.main.children.general.domain.models

import com.yandex.mapkit.geometry.Point

sealed interface GeneralEvent {
    data object Init : GeneralEvent
    data object OnClearSelection : GeneralEvent
    data class OnSelectFilter(val index: Int) : GeneralEvent
    data class SearchField(val text: String) : GeneralEvent

    data class OnPatrolParticipate(val id: Int) : GeneralEvent

    data class OnEventClicked(
        val id: Int,
        val title: String,
        val description: String,
        val picture: String,
        val longitude: Double,
        val latitude: Double
    ) : GeneralEvent

    data class OnMarkClicked(val point: Point) : GeneralEvent
    data class OnSelectCategory(val index: Int) : GeneralEvent
}
