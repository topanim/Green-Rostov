package app.whatrushik.api_sdk.di

import app.whatrushik.api_sdk.api.achievements.achievementsModule
import app.whatrushik.api_sdk.api.assistant.assistantModule
import app.whatrushik.api_sdk.api.ecology.ecologyModule
import app.whatrushik.api_sdk.api.events.eventsModule
import app.whatrushik.api_sdk.api.patrol.patrolModule
import app.whatrushik.api_sdk.common.auth.service.authModule
import app.whatrushik.api_sdk.common.request.requestModule

val apiSdkModule = listOf(
    requestModule,
    authModule,
    patrolModule,
    achievementsModule,
    eventsModule,
    assistantModule,
    ecologyModule
)