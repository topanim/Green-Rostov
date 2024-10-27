package app.whatrsuhik.assistant.di

import app.whatrsuhik.assistant.data.AskAssistantUseCase
import app.whatrsuhik.assistant.domain.AssistantController
import org.koin.dsl.module

val assistantModule = module {
    single { AssistantController(get()) }
    single { AskAssistantUseCase(get()) }
}