package app.whatrsuhik.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.shapes
import app.whatrsuhik.ui.utils.animatedClickable
import app.whatrsuhik.ui.utils.applyComposableIf
import app.whatrsuhik.ui.utils.applyIf

enum class ButtonMode {
    Default,
    Icon,
    IconGhost,
    Secondary,
    Outline,
    Ghost,
    Loading,
    Destructive;

    val foreground: Color
        @Composable
        get() = when (this) {
            Default -> palettes.primaryForeground
            Icon -> palettes.foreground
            Secondary -> palettes.secondaryForeground
            Outline -> palettes.foreground
            Ghost -> palettes.foreground
            Loading -> palettes.mutedForeground
            Destructive -> palettes.destructiveForeground
            IconGhost -> palettes.foreground
        }

    val background: Color
        @Composable
        get() = when (this) {
            Default -> palettes.primary
            Icon -> Color.Transparent
            Secondary -> palettes.secondary
            Outline -> Color.Transparent
            Ghost -> Color.Transparent
            Loading -> palettes.muted
            Destructive -> palettes.destructive
            IconGhost -> Color.Transparent
        }
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    mode: ButtonMode = ButtonMode.Default,
    fill: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) = Box(
    contentAlignment = Alignment.Center,
    content = content,
    modifier = Modifier
        .clip(shapes)
        .background(mode.background)
        .animatedClickable(enabled = enabled, onClick = onClick)
        .applyIf(fill) { fillMaxWidth() }
        .applyComposableIf(
            mode == ButtonMode.Outline || mode == ButtonMode.Icon,
        ) {
            border(1.dp, palettes.border, shapes)
        }
        .then(modifier)
)
