package app.whatrsuhik.ui.components.checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun CheckWithText(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    checked: Boolean,
    enabled: Boolean = true,
    onChange: (Boolean) -> Unit
) = Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
) {
    Check(
        checked = checked,
        enabled = enabled,
        onChange = onChange
    )

    Space(spacing.sm)

    Column {
        if (title != null) {
            Text(
                text = title,
                style = typography.pUiMedium,
                color = if (enabled) palettes.foreground else palettes.mutedForeground,
                modifier = Modifier.fillMaxWidth()
            )

            Space(spacing.sm)
        }

        if (description != null) Text(
            text = description,
            style = typography.subtle,
            color = if (enabled) palettes.foreground else palettes.mutedForeground,
            modifier = Modifier.fillMaxWidth()
        )
    }
}