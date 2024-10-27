package app.whatrsuhik.auth.register.domain.models

sealed interface RegisterAction {
    data object NavigateToMain : RegisterAction
}
