package app.whatrushik.api_sdk.shared.dto

import app.whatrushik.api_sdk.shared.protocols.Parametable
import io.ktor.http.append
import io.ktor.util.StringValues
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Patrol {
    object Parameters {
        @Serializable
        class Me

        @Serializable
        class Pass(
            val id: Int,
            val answers: String
        ): Parametable() {
            override fun toStringValues(): StringValues {
                return StringValues.build {
                    append("answers", answers)
                }
            }
        }
    }

    object Responses {
        @Serializable
        data class Patrol(
            val headers: String,
            @SerialName("y_pos") val yPos: Double,
            @SerialName("x_pos") val xPos: Double,
            val radius: Int,
            val answers: String,
            @SerialName("user_id") val userId: Int,
            val id: Int
        )
    }
}