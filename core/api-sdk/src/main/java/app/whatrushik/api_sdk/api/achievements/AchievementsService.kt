package app.whatrushik.api_sdk.api.achievements

import app.whatrushik.api_sdk.common.request.IRequestService
import app.whatrushik.api_sdk.shared.dto.Achievement
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json

internal class AchievementsService(
    private val requestService: IRequestService,
    private val coder: Json
) : IAchievementsService {
    override suspend fun all(
        data: Achievement.Parameters.All
    ): List<Achievement.Responses.Achievement> = requestService.makeAuthRequest(
        path = "achievement/all",
        method = HttpMethod.Get
    ).body()
}