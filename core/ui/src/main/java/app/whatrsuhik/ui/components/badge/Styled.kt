package app.whatrsuhik.ui.components.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    text: String,
    mode: BadgeMode = BadgeMode.Default
) = Badge(
    modifier = modifier,
    mode = mode
) {
    Text(
        text = text,
        style = typography.subtleMedium,
        color = mode.foreground,
        modifier = Modifier.padding(
            vertical = spacing.xs.dp,
            horizontal = spacing.sm.dp
        )
    )
}