package app.whatrsuhik.auth.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.auth.login.domain.LoginController
import app.whatrsuhik.auth.login.domain.models.LoginAction
import app.whatrsuhik.auth.login.domain.models.LoginEvent
import app.whatrsuhik.auth.login.navigation.LoginProvider
import app.whatrsuhik.auth.register.navigation.RegisterProvider
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.core.navigation.core.rememberNavigator
import app.whatrushik.main.navigation.MainProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class LoginFeature(
    override val data: LoginProvider
) :
    FeatureComponent<LoginController, LoginEvent>(),
    NavComponent<LoginProvider>,
    KoinComponent {
    override val controller: LoginController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigator = rememberNavigator()

        LaunchedEffect(Unit) {
            listener(LoginEvent.Init)
        }

        LoginView(state, listener)

        when (action) {
            null -> Unit

            LoginAction.NavigateToRegister -> {
                controller.clearAction()
                navigator.c.navigate(RegisterProvider)
            }

            LoginAction.NavigateToMain -> {
                controller.clearAction()
                navigator.c.navigate(MainProvider) {
                    popUpTo(0) { inclusive = true }
                }
            }
        }
    }
}
