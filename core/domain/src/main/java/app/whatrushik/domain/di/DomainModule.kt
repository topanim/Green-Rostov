package app.whatrushik.domain.di

import app.whatrushik.domain.impl.getEvents.GetEventsUseCase
import app.whatrushik.domain.impl.getEvents.IGetEventsUseCase
import app.whatrushik.domain.impl.isUserAuthorized.IIsUserAuthorisedUseCase
import app.whatrushik.domain.impl.isUserAuthorized.IsUserAuthorisedUseCase
import org.koin.dsl.module

val domainModule = module {
    single<IIsUserAuthorisedUseCase> { IsUserAuthorisedUseCase(get()) }
    single<IGetEventsUseCase> { GetEventsUseCase(get()) }
}