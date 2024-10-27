package app.whatrsuhik.auth.register.domain.models

data class RegisterState(
    val termsChecked: Boolean = false,
    val name: String = "",
    val surname: String = "",
    val patronymic: String = "",
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
)
