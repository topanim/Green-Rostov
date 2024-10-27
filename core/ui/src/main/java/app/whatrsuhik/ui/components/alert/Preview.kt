package app.whatrsuhik.ui.components.alert

import androidx.compose.runtime.Composable
import app.whatrsuhik.ui.components.preview.PreviewBox
import app.whatrsuhik.ui.icons.Loader2
import app.whatrsuhik.ui.theme.SHUITheme.icons

@Composable
fun AlertPreview() = PreviewBox(
    title = "Alert",
    description = "Displays a callout for user attention."
) {
    Alert(
        icon = icons.Loader2,
        title = "Heads up!",
        description = "You can add components to your app using the cli."
    )
}