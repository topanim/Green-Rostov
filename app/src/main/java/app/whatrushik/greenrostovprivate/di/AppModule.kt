package app.whatrushik.greenrostovprivate.di

import app.whatrushik.api_sdk.common.auth.repository.IAuthRepository
import app.whatrushik.api_sdk.shared.serializers.apiSdkSerializersModule
import app.whatrushik.greenrostovprivate.data.AuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {
    single<IAuthRepository> { AuthRepository(get()) }

    single<Json> {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            serializersModule = apiSdkSerializersModule
        }
    }

    single {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(get())
            }
        }
    }
}