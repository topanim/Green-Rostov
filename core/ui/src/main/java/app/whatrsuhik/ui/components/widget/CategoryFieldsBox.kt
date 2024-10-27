package app.whatrsuhik.ui.components.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun CategoryFieldsBox(
    icon: ImageVector,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) = Column(
    verticalArrangement = Arrangement.spacedBy(spacing.sm.dp),
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = spacing.sm.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = palettes.foreground
        )

        Space(spacing.sm)

        Text(
            text = title,
            style = typography.subleSemibold,
            color = palettes.foreground
        )
    }

    content()
}