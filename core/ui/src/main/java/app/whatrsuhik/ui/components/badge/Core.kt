package app.whatrsuhik.ui.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.utils.applyComposableIf

enum class BadgeMode {
    Default,
    Secondary,
    Outline,
    OutlinePrimary,
    Destructive;

    val foreground: Color
        @Composable get() = when (this) {
            Default -> palettes.primaryForeground
            Secondary -> palettes.secondaryForeground
            Outline -> palettes.foreground
            Destructive -> palettes.destructiveForeground
            OutlinePrimary -> palettes.foreground
        }

    val background: Color
        @Composable get() = when (this) {
            Default -> palettes.primary
            Secondary -> palettes.secondary
            Outline -> Color.Transparent
            Destructive -> palettes.destructive
            OutlinePrimary -> palettes.primary.copy(alpha = 0.5f)
        }

}

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    mode: BadgeMode = BadgeMode.Default,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        content = content,
        modifier = Modifier
            .clip(SHUIShapes.Small)
            .background(mode.background)
            .applyComposableIf(mode == BadgeMode.Outline) {
                border(1.dp, palettes.border, SHUIShapes.Small)
            }
            .applyComposableIf(mode == BadgeMode.OutlinePrimary) {
                border(1.dp, palettes.primary, SHUIShapes.Small)
            }
            .then(modifier)
    )
}
