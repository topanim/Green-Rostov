package app.whatrsuhik.assistant.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.button.ButtonMode
import app.whatrsuhik.ui.components.widget.BaseTextField
import app.whatrsuhik.ui.icons.Send
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUITheme.spacing

@Composable
internal fun ChatField(
    modifier: Modifier = Modifier,
    value: String,
    isIdle: Boolean,
    placeholder: String = "",
    onValueChange: (String) -> Unit,
    onSend: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val onSubmit = { onSend(value); onValueChange("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.sm.dp)
            .padding(bottom = spacing.sm.dp)
    ) {
        BaseTextField(
            value = value,
            contentModifier = Modifier,
            onValueChange = onValueChange,
            actions = KeyboardActions {
                if (isIdle) return@KeyboardActions
                focusManager.clearFocus()
                if (value.isNotEmpty()) onSubmit()
            },
            placeholder = placeholder,
            trailing = {
                Button(
                    mode = if (isIdle) ButtonMode.Loading else ButtonMode.IconGhost,
                    icon = SHUIIcons.Send,
                    enabled = value.isNotEmpty() && !isIdle,
                    onClick = onSubmit
                )
            }
        )
    }
}