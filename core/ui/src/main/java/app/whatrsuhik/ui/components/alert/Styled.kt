package app.whatrsuhik.ui.components.alert

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import app.whatrsuhik.ui.icons.X
import app.whatrsuhik.ui.theme.SHUITheme.icons
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun Alert(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    title: String,
    description: String,
    onCancel: (() -> Unit)? = null,
) = Alert(
    modifier = modifier.background(palettes.popover),
    leading = {
        if (icon != null) Icon(
            modifier = it,
            imageVector = icon,
            tint = palettes.foreground,
            contentDescription = "Alert icon"
        )
    },
    title = { Text(text = title, style = typography.pUiMedium, color = palettes.foreground) },
    description = {
        Text(
            text = description,
            style = typography.subtle,
            color = palettes.foreground
        )
    },
    trailing = {
        if (onCancel != null) Icon(
            imageVector = icons.X,
            tint = palettes.foreground,
            contentDescription = "Close alert",
            modifier = Modifier.clickable(onClick = onCancel)
        )
    }
)