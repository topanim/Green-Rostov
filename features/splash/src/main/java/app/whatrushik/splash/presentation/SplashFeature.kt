package app.whatrushik.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.whatrsuhik.auth.login.navigation.LoginProvider
import app.whatrsuhik.core.foundation.core.FeatureComponent
import app.whatrushik.core.navigation.core.NavComponent
import app.whatrushik.core.navigation.core.rememberNavigator
import app.whatrushik.main.navigation.MainProvider
import app.whatrushik.splash.domain.SplashController
import app.whatrushik.splash.domain.models.SplashAction
import app.whatrushik.splash.domain.models.SplashEvent
import app.whatrushik.splash.navigation.SplashProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashFeature(
    override val data: SplashProvider
) :
    FeatureComponent<SplashController, SplashEvent>(),
    NavComponent<SplashProvider>,
    KoinComponent {
    override val controller: SplashController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigator = rememberNavigator()

        LaunchedEffect(Unit) {
            listener(SplashEvent.Init)
        }

        SplashView(state, listener)

        when (action) {
            null -> Unit

            SplashAction.NavigateToLogin -> {
                controller.clearAction()
                navigator.c.navigate(LoginProvider) {
                    popUpTo(0) { inclusive = true }
                }
            }

            SplashAction.NavigateToMain -> {
                controller.clearAction()
                navigator.c.navigate(MainProvider) {
                    popUpTo(0) { inclusive = true }
                }
            }
        }
    }
}
