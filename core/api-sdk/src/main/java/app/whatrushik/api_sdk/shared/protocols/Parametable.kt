package app.whatrushik.api_sdk.shared.protocols

import io.ktor.util.StringValues
import kotlinx.serialization.Serializable

@Serializable
abstract class Parametable {
    open fun toStringValues(): StringValues = StringValues.Empty
}