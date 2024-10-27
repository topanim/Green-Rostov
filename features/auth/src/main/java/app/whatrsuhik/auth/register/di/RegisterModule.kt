package app.whatrsuhik.auth.register.di

import app.whatrsuhik.auth.register.data.RegisterUserUseCase
import app.whatrsuhik.auth.register.domain.RegisterController
import org.koin.dsl.module

val registerModule = module {
    single { RegisterController(get()) }
    single { RegisterUserUseCase(get(), get()) }
}