package app.whatrushik.api_sdk.shared.serializers

import app.whatrushik.api_sdk.shared.dto.Auth
import app.whatrushik.api_sdk.shared.dto.Event
import app.whatrushik.api_sdk.shared.protocols.Parametable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

val apiSdkSerializersModule = SerializersModule {
    polymorphic(Parametable::class) {
        subclass(Auth.Parameters.Refresh::class, Auth.Parameters.Refresh.serializer())
    }
}