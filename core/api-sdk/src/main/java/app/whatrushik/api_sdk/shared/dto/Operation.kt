package app.whatrushik.api_sdk.shared.dto

import app.whatrushik.api_sdk.shared.protocols.Parametable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Operation {

    object Parameters {
        @Serializable
        class All : Parametable()
    }

    object Responses {
        @Serializable
        data class Operation(
            val id: Int,
            @SerialName("retail_place") val retailPlace: String,
            @SerialName("ecash_sum") val ecashSum: Int,
            @SerialName("total_sum") val totalSum: Int,
            @SerialName("date_time") val dateTime: Int,
            @SerialName("dep_name") val depName: String,
            @SerialName("user_id") val userId: Int,
            @SerialName("request_number") val requestNumber: Int,
            @SerialName("bill_data") val billData: List<BillData>,
            @SerialName("eco_rating_sum") val ecoRatingSum: Int
        )

        @Serializable
        data class BillData(
            val id: Int,
            @SerialName("operation_id") val operationId: Int,
            val nomenclature: String,
            val sum: Int,
            @SerialName("eco_rating") val ecoRating: Int
        )
    }
}