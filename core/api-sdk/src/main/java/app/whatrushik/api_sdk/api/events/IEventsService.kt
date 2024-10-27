package app.whatrushik.api_sdk.api.events

import app.whatrushik.api_sdk.shared.dto.Event


interface IEventsService {
    suspend fun register(data: Event.Parameters.Register)

    suspend fun all(
        data: Event.Parameters.All
    ): List<Event.Responses.Event>

    suspend fun create(
        data: Event.Parameters.Create
    ): Event.Responses.Event

    suspend fun members(
        data: Event.Parameters.EventMembers
    ): List<Event.Responses.EventMembers>

    suspend fun my(
        data: Event.Parameters.My
    ): List<Event.Responses.Event>
}