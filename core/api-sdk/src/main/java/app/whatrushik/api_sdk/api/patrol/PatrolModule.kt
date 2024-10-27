package app.whatrushik.api_sdk.api.patrol

import org.koin.dsl.module

internal val patrolModule = module {
    single<IPatrolService> { PatrolService(get(), get()) }
}