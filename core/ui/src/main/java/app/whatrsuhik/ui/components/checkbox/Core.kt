package app.whatrsuhik.ui.components.checkbox

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.whatrsuhik.ui.theme.SHUITheme.palettes

@Composable
fun Check(
    modifier: Modifier = Modifier,
    checked: Boolean,
    enabled: Boolean = true,
    onChange: (Boolean) -> Unit
) = Checkbox(
    enabled = enabled,
    checked = checked,
    modifier = modifier,
    onCheckedChange = onChange,
    colors = CheckboxDefaults.colors(
        checkedColor = palettes.primary,
        uncheckedColor = palettes.secondary,
        checkmarkColor = palettes.primaryForeground,
        disabledCheckedColor = palettes.muted,
        disabledUncheckedColor = palettes.muted,
        disabledIndeterminateColor = palettes.muted
    )
)