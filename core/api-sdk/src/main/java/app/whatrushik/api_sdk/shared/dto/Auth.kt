package app.whatrushik.api_sdk.shared.dto

import app.whatrushik.api_sdk.shared.protocols.Parametable
import app.whatrushik.api_sdk.shared.protocols.Responsable
import io.ktor.util.StringValues
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Auth {
    object Parameters {
        @Serializable
        data class Login(
            val username: String,
            val password: String
        ) : Parametable()

        @Serializable
        data class Register(
            val username: String,
            val password: String,
            @SerialName("first_name") val firstName: String,
            @SerialName("last_name") val lastName: String,
            val patronymic: String,
            @SerialName("british_date") val britishDate: String
        ) : Parametable()

        @Serializable
        data class Refresh(
            val refreshToken: String
        ) : Parametable() {
            override fun toStringValues() = StringValues.build {
                append("refresh", refreshToken)
            }
        }

        @Serializable
        data class Me(val refreshToken: String) : Parametable()
    }

    object Responses {
        @Serializable
        data class Registered(
            val username: String
        ) : Responsable

        @Serializable
        data class Login(
            @SerialName("access_token") val accessToken: String,
            @SerialName("refresh_token") val refreshToken: String,
            @SerialName("token_type") val tokenType: String,
            val exp: String
        ) : Responsable

        @Serializable
        data class Refresh(
            @SerialName("access_token") val accessToken: String,
            @SerialName("refresh_token") val refreshToken: String,
            @SerialName("token_type") val tokenType: String,
            val exp: String
        ) : Responsable

        @Serializable
        data class Me(
            val username: String
        ) : Responsable
    }
}