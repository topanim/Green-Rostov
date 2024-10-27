package app.whatrushik.domain.impl.getEvents

import app.whatrushik.api_sdk.api.events.IEventsService
import app.whatrushik.api_sdk.shared.dto.Event

internal class GetEventsUseCase(
    private val eventService: IEventsService
) : IGetEventsUseCase {
    override suspend fun execute(): List<Event.Responses.Event> {
        return eventService.all(Event.Parameters.All())
    }
}
