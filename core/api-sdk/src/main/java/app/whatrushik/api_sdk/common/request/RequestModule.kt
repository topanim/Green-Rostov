package app.whatrushik.api_sdk.common.request

import org.koin.dsl.module


internal val requestModule = module {
    single<IRequestService> {
        RequestService(
            get(),
            "http://green.whatrushik.fun:5000/",
            get()
        )
    }
}