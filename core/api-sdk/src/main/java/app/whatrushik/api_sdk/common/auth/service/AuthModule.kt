package app.whatrushik.api_sdk.common.auth.service


import org.koin.dsl.module

internal val authModule = module {
    single<IAuthService> { AuthService(get(), get()) }
}