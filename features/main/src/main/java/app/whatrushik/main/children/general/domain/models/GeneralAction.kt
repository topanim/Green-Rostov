package app.whatrushik.main.children.general.domain.models

sealed interface GeneralAction {
    data class NavigateToEventDetail(
        val id: Int,
        val title: String,
        val description: String,
        val picture: String,
        val longitude: Double,
        val latitude: Double
    ) : GeneralAction
}
