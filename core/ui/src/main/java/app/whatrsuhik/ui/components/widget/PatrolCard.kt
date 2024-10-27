package app.whatrsuhik.ui.components.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.button.ButtonMode
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.styled_box.StyledBox
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun PatrolCard(
    modifier: Modifier = Modifier,
    header: String,
    passing: Boolean = false,
    onLongPress: () -> Unit = {},
    onParticipate: () -> Unit = {},
) = Box(
    modifier = modifier
        .pointerInput(Unit) {
            detectTapGestures(
                onLongPress = {
                    onLongPress()
                }
            )
        }
) {
    StyledBox(
        modifier = Modifier
            .fillMaxWidth()
            .background(palettes.secondary)
            .padding(spacing.sm.dp),
    ) {
        Column {
            Text(
                text = header,
                style = typography.small,
                color = palettes.foreground
            )

            Space(spacing.sm)

            Button(
                fill = true,
                mode = if (passing) ButtonMode.Loading else ButtonMode.Default,
                enabled = !passing,
                label = "Все в порядке",
                onClick = onParticipate
            )
        }
    }
}