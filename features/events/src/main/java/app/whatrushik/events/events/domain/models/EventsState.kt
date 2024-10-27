package app.whatrushik.events.events.domain.models

import app.whatrushik.api_sdk.shared.dto.Event

data class EventsState(
    val events: List<Event.Responses.Event> = emptyList()
)
