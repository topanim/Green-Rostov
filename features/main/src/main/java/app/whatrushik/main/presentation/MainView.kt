package app.whatrushik.main.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrushik.core.navigation.bottom_navigation.BottomNavBar
import app.whatrushik.core.navigation.core.NavigationHost
import app.whatrushik.core.navigation.core.rememberHostNavigator
import app.whatrushik.main.children.general.navigation.GeneralProvider
import app.whatrushik.main.di.navList
import app.whatrushik.main.domain.model.MainScreenEvent
import app.whatrushik.main.domain.model.MainScreenState
import app.whatrushik.main.presentation.MainFeature.Companion.mainChildrenRegistry

@Composable
fun MainView(
    state: MainScreenState,
    listener: Listener<MainScreenEvent>,
) {
    val navigator = rememberHostNavigator()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navigator = navigator,
                screens = navList
            )
        }
    ) {
        NavigationHost(
            navigator = navigator,
            start = GeneralProvider,
            registry = mainChildrenRegistry,
            modifier = Modifier
                .background(palettes.background)
                .padding(it)
        )
    }
}