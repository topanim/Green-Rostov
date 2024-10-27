package app.whatrushik.api_sdk.shared.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Ecology {
    object Parameters {
        @Serializable
        class Get
    }

    object Responses {
        @Serializable
        data class UV(
            @SerialName("uv") val value: Float
        )
    }
}