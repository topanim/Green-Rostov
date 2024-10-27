package app.whatrushik.events.detailEvent.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing

@Composable
fun DescriptionEvent(text: String) {
    Column {
        Text(
            "Описание мероприятия",
            style = SHUITheme.typography.subleSemibold,
            color = SHUITheme.palettes.foreground
        )
        Space(spacing.sm)
        Text(
            text,
            modifier = Modifier.animateContentSize(),
            color = SHUITheme.palettes.foreground,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}