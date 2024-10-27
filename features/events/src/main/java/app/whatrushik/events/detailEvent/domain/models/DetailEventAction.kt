package app.whatrushik.events.detailEvent.domain.models

sealed interface DetailEventAction {
    data object BackButtonClicked : DetailEventAction
}