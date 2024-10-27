package app.whatrushik.api_sdk.shared.dto

import app.whatrushik.api_sdk.shared.protocols.Parametable
import kotlinx.serialization.Serializable

object Advice {
    object Parameters {
        @Serializable
        class Get : Parametable()
    }

    object Responses {
        @Serializable
        data class Advice(
            val id: Int,
            val name: String,
            val description: String
        )
    }
}