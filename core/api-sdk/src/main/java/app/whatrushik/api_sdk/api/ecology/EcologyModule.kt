package app.whatrushik.api_sdk.api.ecology

import org.koin.dsl.module

internal val ecologyModule = module {
    single<IEcologyService> { EcologyService(get(), get()) }
}