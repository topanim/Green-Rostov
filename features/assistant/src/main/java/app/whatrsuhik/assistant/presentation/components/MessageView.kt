package app.whatrsuhik.assistant.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.whatrsuhik.assistant.domain.models.Message
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
internal fun MessageView(
    modifier: Modifier = Modifier,
    message: Message
) = Box(
    modifier = modifier.fillMaxWidth()
) {
    Row(
        modifier = Modifier
            .clip(SHUIShapes.Medium)
            .background(
                color = if (message.authorIsMe) palettes.primary
                else palettes.secondary
            )
            .align(
                if (message.authorIsMe) Alignment.CenterEnd
                else Alignment.CenterStart
            ),
    ) {
        Text(
            text = message.content,
            style = typography.pUi,
            color = if (message.authorIsMe) palettes.primaryForeground
            else palettes.secondaryForeground,
            modifier = Modifier.padding(
                horizontal = spacing.md.dp,
                vertical = (spacing.sm + spacing.xs).dp
            )
        )
    }
}