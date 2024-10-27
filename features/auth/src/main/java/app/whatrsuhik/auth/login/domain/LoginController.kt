package app.whatrsuhik.auth.login.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.auth.login.data.LoginUserUseCase
import app.whatrsuhik.auth.login.domain.models.LoginAction
import app.whatrsuhik.auth.login.domain.models.LoginEvent
import app.whatrsuhik.auth.login.domain.models.LoginState
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.safeExecute

internal class LoginController(
    private val loginUserUseCase: LoginUserUseCase
) : UIController<LoginState, LoginAction, LoginEvent>(
    LoginState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) = when (viewEvent) {
        LoginEvent.Init -> init()
        is LoginEvent.OnFocusTakenOff -> updateAll(viewEvent)
        LoginEvent.OnLoginClicked -> onLoginClick()
        LoginEvent.OnForgotPasswordClicked -> setAction(LoginAction.NavigateToRegister)
        LoginEvent.OnRegisterClicked -> setAction(LoginAction.NavigateToRegister)
    }

    private fun init() {}

    private fun updateAll(
        viewEvent: LoginEvent.OnFocusTakenOff
    ) = updateState {
        Log.d("d", "OnFocusTakenOff: $viewEvent")
        copy(
            login = viewEvent.login,
            password = viewEvent.password
        )
    }

    private fun onLoginClick() {
        val login = viewState.login
        val password = viewState.password

        Log.d(
            "d",
            "Login: $login, Password: $password"
        )

        if (login.isEmpty() || password.isEmpty()) {
//            setAction(LoginAction.ShowError)
            return
        }

        safeExecute(
            scope = viewModelScope,
            block = {
                val loginResult = loginUserUseCase.execute(LoginUserUseCase.Data(login, password))

                Log.d("d", "Login Result: $loginResult")

                if (loginResult.isSuccess) {
                    setAction(LoginAction.NavigateToMain)
                } else {
                    Log.d("d", "Login Error: $loginResult")
//            setAction(LoginAction.ShowError)
                }
            }
        )
    }
}
