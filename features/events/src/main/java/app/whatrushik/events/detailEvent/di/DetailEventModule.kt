package app.whatrushik.events.detailEvent.di

import app.whatrushik.events.detailEvent.domain.DetailEventController
import org.koin.dsl.module

val detailEventModule = module {
    single { DetailEventController(get()) }
}
