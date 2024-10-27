package app.whatrsuhik.auth.login.di

import app.whatrsuhik.auth.login.data.LoginUserUseCase
import app.whatrsuhik.auth.login.domain.LoginController
import org.koin.dsl.module

val loginModule = module {
    single { LoginController(get()) }
    single { LoginUserUseCase(get(), get()) }
}