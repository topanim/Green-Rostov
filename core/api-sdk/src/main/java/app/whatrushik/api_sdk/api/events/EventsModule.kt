package app.whatrushik.api_sdk.api.events

import org.koin.dsl.module

internal val eventsModule = module {
    single<IEventsService> { EventsService(get(), get()) }
}