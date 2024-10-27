package app.whatrsuhik.auth.register.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.auth.register.data.RegisterUserUseCase
import app.whatrsuhik.auth.register.domain.models.RegisterAction
import app.whatrsuhik.auth.register.domain.models.RegisterEvent
import app.whatrsuhik.auth.register.domain.models.RegisterState
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.safeExecute

internal class RegisterController(
    private val registerUseCase: RegisterUserUseCase
) : UIController<RegisterState, RegisterAction, RegisterEvent>(
    RegisterState()
) {
    override fun obtainEvent(viewEvent: RegisterEvent) = when (viewEvent) {
        RegisterEvent.Init -> init()
        is RegisterEvent.OnTermsAcceptedChanged -> updateState { copy(termsChecked = viewEvent.checked) }
        RegisterEvent.OnRegisterClicked -> onRegisterClicked()
        is RegisterEvent.OnFocusTakenOff -> updateAll(viewEvent)
    }

    private fun init() {}

    private fun updateAll(
        viewEvent: RegisterEvent.OnFocusTakenOff
    ) = updateState {
        Log.d("d", "OnFocusTakenOff: $viewEvent")
        copy(
            name = viewEvent.name,
            surname = viewEvent.surname,
            patronymic = viewEvent.patronymic,
            email = viewEvent.email,
            password = viewEvent.password,
            repeatPassword = viewEvent.repeatPassword
        )
    }

    private fun onRegisterClicked() {
        val name = viewState.name
        val surname = viewState.surname
        val patronymic = viewState.patronymic
        val email = viewState.email
        val password = viewState.password
        val repeatPassword = viewState.repeatPassword
        val termsChecked = viewState.termsChecked

        Log.d(
            "d",
            "Register: $name, $surname, $patronymic, $email, $password, $repeatPassword, $termsChecked"
        )

        if (name.isBlank()
            || surname.isBlank()
            || patronymic.isBlank()
            || email.isBlank()
            || password.isBlank()
            || repeatPassword.isBlank()
            || !termsChecked
            || password != repeatPassword
        ) {
            Log.d("d", "Register Error: Invalid data")
            return
        }

        safeExecute(
            scope = viewModelScope,
            block = {
                Log.d("d", "Start register")

                val registerResult = registerUseCase.execute(
                    RegisterUserUseCase.Data(
                        firstName = name,
                        lastName = surname,
                        patronymic = patronymic,
                        username = email,
                        password = password,
                        britishDate = "2024-10-26T08:17:09.321Z"
                    )
                )

                Log.d("d", "Register Result: $registerResult")

                if (registerResult.isSuccess) {
                    setAction(RegisterAction.NavigateToMain)
                } else {
                    Log.d("d", "Register Error: $registerResult")
//                setAction(RegisterAction.ShowError)
                }
            }
        ) {

        }
    }
}
