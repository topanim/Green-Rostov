package app.whatrushik.greenrostovprivate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import app.whatrsuhik.ui.theme.LocalSHUIPalette
import app.whatrsuhik.ui.theme.LocalSHUIShape
import app.whatrsuhik.ui.theme.LocalSHUITypography
import app.whatrsuhik.ui.theme.LocalThemeIsDark
import app.whatrsuhik.ui.theme.SHUIPalette
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITypography

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorPalette = SHUIPalette.green(darkTheme)

    CompositionLocalProvider(
        LocalSHUIShape provides SHUIShapes.Medium,
        LocalSHUIPalette provides colorPalette,
        LocalSHUITypography provides SHUITypography.Common,
        LocalThemeIsDark provides darkTheme,
        content = content
    )
}