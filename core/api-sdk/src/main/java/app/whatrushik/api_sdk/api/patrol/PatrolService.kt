package app.whatrushik.api_sdk.api.patrol

import app.whatrushik.api_sdk.common.request.IRequestService
import app.whatrushik.api_sdk.shared.dto.Patrol
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class PatrolService(
    private val requestService: IRequestService,
    private val coder: Json
) : IPatrolService {
    override suspend fun me(
        data: Patrol.Parameters.Me
    ): List<Patrol.Responses.Patrol> = requestService.makeAuthRequest(
        path = "user/patrol/me",
        method = HttpMethod.Get
    ).body()

    override suspend fun pass(
        data: Patrol.Parameters.Pass
    ) {
        requestService.makeAuthRequest(
            path = "user/patrol/${data.id}",
            method = HttpMethod.Post,
            parameters = data
        )
    }
}