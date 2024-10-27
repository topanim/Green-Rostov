package app.whatrushik.events.detailEvent.domain.models

sealed interface DetailEventEvent {
    data class Init(
        val id: Int,
        val title: String,
        val description: String,
        val picture: String,
        val longitude: Double,
        val latitude: Double
    ) : DetailEventEvent


    data class OnParticipantClicked(val id: Int) : DetailEventEvent
    data object ClickButton : DetailEventEvent
    data object IsFavoriteButton : DetailEventEvent
    data object ShareClicked : DetailEventEvent
    data object BackButtonClicked : DetailEventEvent
}