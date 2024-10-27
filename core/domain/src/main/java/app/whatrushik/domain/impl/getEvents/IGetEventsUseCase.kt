package app.whatrushik.domain.impl.getEvents

import app.whatrushik.api_sdk.shared.dto.Event
import app.whatrushik.domain.api.UseCase

interface IGetEventsUseCase : UseCase<List<Event.Responses.Event>> {
}