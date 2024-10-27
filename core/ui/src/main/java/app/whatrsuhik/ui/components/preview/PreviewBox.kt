package app.whatrsuhik.ui.components.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
internal fun PreviewBox(
    title: String,
    description: String,
    content: @Composable ColumnScope.() -> Unit
) = Column(
    verticalArrangement = Arrangement.spacedBy(spacing.md.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(20.dp)
) {
    Text(
        text = title,
        style = typography.h4,
        color = palettes.foreground,
        modifier = Modifier.fillMaxWidth()
    )
    Text(
        text = description,
        style = typography.pUi,
        color = palettes.foreground,
        modifier = Modifier.fillMaxWidth()
    )
    Space(spacing.sm)
    content()
}