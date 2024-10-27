package app.whatrsuhik.ui.theme

import androidx.compose.runtime.compositionLocalOf

val LocalSHUISpacing = compositionLocalOf { SHUISpacing.Common }

data class SHUISpacing(
    val none: Int,
    val xs: Int,
    val sm: Int,
    val md: Int,
    val lg: Int,
    val xl: Int
) {
    companion object Defaults {
        val Common = SHUISpacing(
            none = 0,
            xs = 4,
            sm = 8,
            md = 16,
            lg = 24,
            xl = 32
        )
    }
}