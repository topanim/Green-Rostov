package app.whatrushik.api_sdk.api.assistant

import app.whatrushik.api_sdk.shared.dto.Assistant

interface IAssistantService {
    suspend fun question(
        data: Assistant.Parameters.Question
    ): Assistant.Responses.Answer

    suspend fun testQuestion(
        data: Assistant.Parameters.TestQuestion
    ): Assistant.Responses.Answer
}