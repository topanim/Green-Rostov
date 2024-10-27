package app.whatrushik.greenrostovprivate.data

import android.content.Context
import androidx.datastore.core.Serializer
import app.whatrsuhik.core.foundation.data.Store
import app.whatrushik.api_sdk.common.auth.repository.IAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class AuthRepository(
    context: Context
) : IAuthRepository, Store<IAuthRepository.AuthTokens>(
    context = context, fileName = "auth_tokens.json", serializer = AppConfigSerializer
) {
    object AppConfigSerializer : Serializer<IAuthRepository.AuthTokens> {
        override val defaultValue: IAuthRepository.AuthTokens
            get() = IAuthRepository.AuthTokens("", "")

        override suspend fun readFrom(input: InputStream): IAuthRepository.AuthTokens = try {
            Json.decodeFromString(
                deserializer = IAuthRepository.AuthTokens.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: Exception) {
            println(e.stackTrace)
            defaultValue
        }

        override suspend fun writeTo(t: IAuthRepository.AuthTokens, output: OutputStream) =
            withContext(Dispatchers.IO) {
                output.write(
                    Json.encodeToString(
                        serializer = IAuthRepository.AuthTokens.serializer(), value = t
                    ).encodeToByteArray()
                )
            }
    }

    override suspend fun setTokens(tokens: IAuthRepository.AuthTokens) {
        saveData(tokens)
    }

    override suspend fun getTokens(): IAuthRepository.AuthTokens? =
        getData()
}