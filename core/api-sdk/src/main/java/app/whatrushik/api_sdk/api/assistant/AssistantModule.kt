package app.whatrushik.api_sdk.api.assistant

import org.koin.dsl.module

internal val assistantModule = module {
    single<IAssistantService> { AssistantService(get(), get()) }
}