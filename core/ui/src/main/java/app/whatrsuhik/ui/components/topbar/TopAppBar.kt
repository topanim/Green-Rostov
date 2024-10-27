package app.whatrsuhik.ui.components.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.icons.ArrowLeft
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography
import app.whatrushik.what_shadcn_ui.core.react.useState

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    trailing: @Composable () -> Unit = {},
    onBackPress: (() -> Unit)? = null
) = Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val (clicked, setClicked) = useState(false)

        if (onBackPress != null) {
            Icon(
                imageVector = SHUIIcons.ArrowLeft,
                contentDescription = "Go back",
                tint = palettes.foreground,
                modifier = Modifier
                    .padding(spacing.sm.dp)
                    .clip(SHUIShapes.Circle)
                    .clickable {
                        if (!clicked) onBackPress()
                        setClicked(true)
                    }
            )

            Space(spacing.md)
        }

        Text(
            text = title,
            style = typography.h4,
            color = palettes.foreground
        )
    }

    trailing()
}