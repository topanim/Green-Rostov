package app.whatrsuhik.auth.login.domain.models

sealed interface LoginAction {
    data object NavigateToRegister : LoginAction
    data object NavigateToMain : LoginAction
}
