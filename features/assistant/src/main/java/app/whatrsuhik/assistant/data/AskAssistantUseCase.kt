package app.whatrsuhik.assistant.data

import app.whatrushik.api_sdk.api.assistant.IAssistantService
import app.whatrushik.api_sdk.shared.dto.Assistant
import app.whatrushik.domain.api.DataUseCase

internal class AskAssistantUseCase(
    private val assistantService: IAssistantService
) : DataUseCase<String, Result<Assistant.Responses.Answer>> {

    override suspend fun execute(
        data: String
    ): Result<Assistant.Responses.Answer> = try {
        val questionResponse = assistantService.question(Assistant.Parameters.Question(data))
//        val questionResponse = assistantService.testQuestion(Assistant.Parameters.TestQuestion(data))
        Result.success(questionResponse)
    } catch (e: Exception) {
        Result.failure(e)
    }
}