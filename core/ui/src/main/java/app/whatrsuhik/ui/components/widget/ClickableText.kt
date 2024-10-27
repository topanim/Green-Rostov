package app.whatrsuhik.ui.components.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun ClickableText(
    text: String,
    onClick: () -> Unit,
    style: TextStyle = TextStyle.Default,
    underline: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }

    Text(
        text = text,
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        ),
        style = style.copy(
            textDecoration = if (underline) TextDecoration.Underline else null
        )
    )
}