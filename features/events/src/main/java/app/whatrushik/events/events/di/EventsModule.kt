package app.whatrushik.events.events.di

import app.whatrushik.events.events.domain.EventsController
import org.koin.dsl.module

val eventsModule = module {
    single { EventsController(get()) }
}