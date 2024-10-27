package app.whatrushik.events.createEvent.di

import app.whatrushik.events.createEvent.domain.CreateEventController
import org.koin.dsl.module

val createEventModule = module {
    single { CreateEventController() }
}