package app.whatrushik.splash.domain.models

sealed interface SplashAction {
    data object NavigateToLogin : SplashAction
    data object NavigateToMain : SplashAction
}
