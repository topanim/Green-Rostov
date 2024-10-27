package app.whatrsuhik.ui.theme

import androidx.compose.runtime.Composable

object SHUITheme {
    val icons
        @Composable get() = SHUIIcons

    val isDarkTheme
        @Composable get() = LocalThemeIsDark.current

    val palettes
        @Composable get() = LocalSHUIPalette.current

    val colors
        @Composable get() = LocalSHUIColor.current

    val spacing
        @Composable get() = LocalSHUISpacing.current

    val typography
        @Composable get() = LocalSHUITypography.current

    val shapes: SHUIShape
        @Composable get() = LocalSHUIShape.current
}