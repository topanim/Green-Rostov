package app.whatrushik.splash.di

import app.whatrushik.splash.domain.SplashController
import org.koin.dsl.module

val splashModule = module {
    single { SplashController(get()) }
}