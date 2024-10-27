package app.whatrushik.api_sdk.api.events

import app.whatrushik.api_sdk.common.request.IRequestService
import app.whatrushik.api_sdk.shared.dto.Event
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class EventsService(
    private val requestService: IRequestService,
    private val coder: Json
) : IEventsService {
    override suspend fun register(
        data: Event.Parameters.Register
    ) {
        requestService.makeAuthRequest(
            path = "events/register",
            method = HttpMethod.Post,
            body = coder.encodeToString(data)
        )
    }

    override suspend fun all(
        data: Event.Parameters.All
    ): List<Event.Responses.Event> = requestService.makeAuthRequest(
        path = "events/all",
        method = HttpMethod.Get
    ).body()

    override suspend fun create(
        data: Event.Parameters.Create
    ): Event.Responses.Event = requestService.makeAuthRequest(
        path = "events/create",
        method = HttpMethod.Post,
        body = coder.encodeToString(data)
    ).body()

    override suspend fun members(
        data: Event.Parameters.EventMembers
    ): List<Event.Responses.EventMembers> = requestService.makeAuthRequest(
        path = "events/members/${data.eventId}",
        method = HttpMethod.Get
    ).body()
}