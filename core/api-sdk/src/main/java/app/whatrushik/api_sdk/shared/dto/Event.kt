package app.whatrushik.api_sdk.shared.dto

import app.whatrushik.api_sdk.shared.protocols.Parametable
import app.whatrushik.api_sdk.shared.protocols.Responsable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Event {
    object Parameters {
        @Serializable
        class All : Parametable()

        @Serializable
        data class Create(
            val picture: String,
            val name: String,
            val description: String,
            val latitude: Double,
            val longitude: Double
        ) : Parametable()

        @Serializable
        data class Register(
            @SerialName("event_id") val eventId: Int
        ) : Parametable()

        @Serializable
        data class EventMembers(
            @SerialName("event_id") val eventId: Int
        ) : Parametable()

        @Serializable
        class My : Parametable()
    }

    object Responses {

        @Serializable
        data class Event(
            val picture: String,
            val name: String,
            val description: String,
            val longitude: Double,
            val latitude: Double,
            val id: Int
        ) : Responsable

        @Serializable
        data class EventMembers(
            @SerialName("event_id") val eventId: Int,
            val member: List<Member>
        ) : Responsable

        @Serializable
        data class Member(
            @SerialName("first_name") val firstName: String,
            @SerialName("last_name") val lastName: String,
            val patronymic: String
        ) : Responsable
    }
}