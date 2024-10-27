package app.whatrushik.api_sdk.api.achievements

import app.whatrushik.api_sdk.shared.dto.Achievement

interface IAchievementsService {
    suspend fun all(
        data: Achievement.Parameters.All
    ): List<Achievement.Responses.Achievement>
}