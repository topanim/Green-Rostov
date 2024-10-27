package app.whatrushik.api_sdk.api.assistant

import app.whatrushik.api_sdk.common.request.IRequestService
import app.whatrushik.api_sdk.shared.dto.Assistant
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class AssistantService(
    private val requestService: IRequestService,
    private val coder: Json
) : IAssistantService {
    override suspend fun question(
        data: Assistant.Parameters.Question
    ): Assistant.Responses.Answer = requestService.makeAuthRequest(
        method = HttpMethod.Post,
        path = "expert",
        body = coder.encodeToString(data)
    ).body()


    override suspend fun testQuestion(
        data: Assistant.Parameters.TestQuestion
    ): Assistant.Responses.Answer = requestService.makeAuthRequest(
        method = HttpMethod.Post,
        path = "expert/test",
        body = coder.encodeToString(data)
    ).body()
}