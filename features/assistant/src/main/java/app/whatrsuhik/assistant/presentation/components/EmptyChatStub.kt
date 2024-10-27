package app.whatrsuhik.assistant.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.widget.DancingMan
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
internal fun EmptyChatStub(
    modifier: Modifier = Modifier,
    onStart: () -> Unit
) = Column(
    modifier = modifier.width(230.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    DancingMan()

    Text(
        text = "Это - ваш личный нейросетевой ассистент-эколог",
        style = typography.subtle,
        color = palettes.foreground,
        textAlign = TextAlign.Center
    )

    Space(spacing.md)

    Button(
        fill = true,
        label = "Начать диалог",
        onClick = onStart,
    )
}