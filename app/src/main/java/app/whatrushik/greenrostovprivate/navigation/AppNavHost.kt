package app.whatrushik.greenrostovprivate.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.whatrsuhik.auth.login.navigation.loginRegistry
import app.whatrsuhik.auth.register.navigation.registerRegistry
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrushik.core.navigation.core.NavigationHost
import app.whatrushik.core.navigation.core.Navigator
import app.whatrushik.core.navigation.core.rememberHostNavigator
import app.whatrushik.events.createEvent.navigation.createEventRegistry
import app.whatrushik.events.detailEvent.navigation.detailEventRegistry
import app.whatrushik.main.navigation.mainRegistry
import app.whatrushik.splash.navigation.SplashProvider
import app.whatrushik.splash.navigation.splashRegistry

@Composable
fun AppNavHost(
    navigator: Navigator = rememberHostNavigator()
) = NavigationHost(
    start = SplashProvider,
    navigator = navigator,
    modifier = Modifier
        .fillMaxSize()
        .background(palettes.background)
) {
    mainRegistry()
    loginRegistry()
    registerRegistry()
    splashRegistry()
    createEventRegistry()
    detailEventRegistry()
}