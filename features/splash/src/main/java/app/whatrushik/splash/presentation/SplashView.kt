package app.whatrushik.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.widget.DancingMan
import app.whatrsuhik.ui.icons.GreenRostov
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrushik.splash.domain.models.SplashEvent
import app.whatrushik.splash.domain.models.SplashState

@Composable
fun SplashView(
    state: SplashState,
    listener: Listener<SplashEvent>
) = Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    DancingMan()

    Space(spacing.sm)

    Image(
        imageVector = GreenRostov(palettes.primary, palettes.foreground),
        contentDescription = "Green Rostov"
    )
}
