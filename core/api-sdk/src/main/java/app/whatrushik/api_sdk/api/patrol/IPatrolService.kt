package app.whatrushik.api_sdk.api.patrol

import app.whatrushik.api_sdk.shared.dto.Patrol

interface IPatrolService {
    suspend fun me(
        data: Patrol.Parameters.Me
    ): List<Patrol.Responses.Patrol>

    suspend fun pass(data: Patrol.Parameters.Pass)
}