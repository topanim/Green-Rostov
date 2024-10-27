package app.whatrushik.api_sdk.shared.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Achievement {
    object Parameters {
        @Serializable
        class All

        @Serializable
        class Leaderboard
    }

    object Responses {
        @Serializable
        data class Achievement(
            @SerialName("achievements_id") val achievementId: Int,
            @SerialName("user_id") val userId: Int,
            val header: String,
            val text: String,
            val exp: Int,
            val image: String,
            val complete: Boolean
        )

        @Serializable
        data class AchievementLite(
            val name: String,
            val exp: Int
        )
    }
}