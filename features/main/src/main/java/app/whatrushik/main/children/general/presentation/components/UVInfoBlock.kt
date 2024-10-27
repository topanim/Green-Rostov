package app.whatrushik.main.children.general.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.icons.RadialDiagram
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography


@Composable
fun UVInfoBlock(
    modifier: Modifier = Modifier,
    uvIndex: String
) = Box(
    modifier = modifier
        .border(1.dp, palettes.border, SHUIShapes.Medium)
        .clip(SHUIShapes.Medium)
        .background(palettes.secondary)
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(spacing.md.dp, spacing.sm.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Ростов-на-Дону",
            style = typography.large,
            color = palettes.foreground
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = SHUIIcons.RadialDiagram,
                contentDescription = "uv index",
                tint = palettes.primary
            )

            Space(spacing.xs)

            Text(
                text = "${uvIndex}% индекс",
                style = typography.large,
                color = palettes.foreground
            )
        }
    }
}