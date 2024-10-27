package app.whatrsuhik.auth.login.domain.models

sealed interface LoginEvent {
    data object Init : LoginEvent

    data class OnFocusTakenOff(
        val login: String,
        val password: String,
    ) : LoginEvent

    data object OnLoginClicked : LoginEvent
    data object OnRegisterClicked : LoginEvent
    data object OnForgotPasswordClicked : LoginEvent
}
