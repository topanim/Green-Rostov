package app.whatrushik.api_sdk.shared.utils

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

object ParamsEncodeUtils {
    inline fun <reified T : Any> encodeToMap(obj: T, json: Json = Json): Map<String, Any?> {
        return jsonObjectToMap(json.encodeToJsonElement(obj).jsonObject)
    }

    fun jsonObjectToMap(element: JsonObject): Map<String, Any?> {
        return element.entries.associate {
            it.key to extractValue(it.value)
        }
    }

    private fun extractValue(element: JsonElement): Any? {
        return when (element) {
            is JsonNull -> null
            is JsonPrimitive -> element.content
            is JsonArray -> element.map { extractValue(it) }
            is JsonObject -> jsonObjectToMap(element)
        }
    }
}