package app.whatrushik.greenrostovprivate

import android.app.Application
import app.whatrsuhik.assistant.di.assistantModule
import app.whatrsuhik.auth.login.di.loginModule
import app.whatrsuhik.auth.register.di.registerModule
import app.whatrsuhik.profile.profile.di.profileModule
import app.whatrushik.api_sdk.di.apiSdkModule
import app.whatrushik.domain.di.domainModule
import app.whatrushik.events.createEvent.di.createEventModule
import app.whatrushik.events.detailEvent.di.detailEventModule
import app.whatrushik.events.events.di.eventsModule
import app.whatrushik.greenrostovprivate.di.appModule
import app.whatrushik.main.di.mainModule
import app.whatrushik.splash.di.splashModule
import com.yandex.mapkit.MapKitFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        MapKitFactory.setApiKey("3ba5babf-2aeb-4e27-aaba-4d9b9229c2b0")
        MapKitFactory.initialize(this)

        startKoin {
            androidContext(this@MainApp)
            modules(
                apiSdkModule + listOf(
                    appModule,
                    domainModule,
                    mainModule,
                    loginModule,
                    registerModule,
                    splashModule,
                    createEventModule,
                    detailEventModule,
                    assistantModule,
                    profileModule,
                    eventsModule
                )
            )
        }
    }
}