package app.whatrsuhik.profile.profile.di

import app.whatrsuhik.profile.profile.domain.ProfileController
import org.koin.dsl.module

val profileModule = module {
    single { ProfileController(get(),get()) }
}