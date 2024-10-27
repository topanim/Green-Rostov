package app.whatrushik.splash.domain.models

sealed interface SplashEvent {
    data object Init : SplashEvent
}
