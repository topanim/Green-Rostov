package app.whatrushik.api_sdk.api.achievements

import org.koin.dsl.module

internal val achievementsModule = module {
    single<IAchievementsService> { AchievementsService(get(), get()) }
}