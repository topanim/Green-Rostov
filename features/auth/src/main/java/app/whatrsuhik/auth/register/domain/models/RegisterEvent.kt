package app.whatrsuhik.auth.register.domain.models

sealed interface RegisterEvent {
    data object Init : RegisterEvent
    data class OnTermsAcceptedChanged(val checked: Boolean) : RegisterEvent

    data class OnFocusTakenOff(
        val name: String,
        val surname: String,
        val patronymic: String,
        val email: String,
        val password: String,
        val repeatPassword: String
    ) : RegisterEvent

    data object OnRegisterClicked : RegisterEvent
}
