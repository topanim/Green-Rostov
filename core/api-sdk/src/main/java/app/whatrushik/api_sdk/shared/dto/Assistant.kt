package app.whatrushik.api_sdk.shared.dto

import app.whatrushik.api_sdk.shared.protocols.Parametable
import app.whatrushik.api_sdk.shared.protocols.Responsable
import kotlinx.serialization.Serializable

object Assistant {
    object Parameters {
        @Serializable
        data class TestQuestion(
            val question: String
        ) : Parametable()

        @Serializable
        data class Question(
            val question: String
        ) : Parametable()
    }

    object Responses {

        @Serializable
        data class Answer(
            val answer: String,
            val question: String
        ) : Responsable

    }
}