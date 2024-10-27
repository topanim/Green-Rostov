package app.whatrsuhik.profile.profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.button.ButtonMode
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.components.styled_box.StyledBox
import app.whatrsuhik.ui.icons.ArrowRight
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun ProfileInfo(
    name: String,
    surname: String,
    city: String
) = StyledBox {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = spacing.md.dp)
            .padding(start = spacing.md.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            UserAvatar()
            Space(spacing.md)
            Column {
                Text(
                    text = "$name $surname",
                    style = typography.large,
                    color = palettes.foreground
                )
                VerticalSpace(2)
                Text(
                    text = "Ростов-на-Дону",
                    style = typography.subtle,
                    color = palettes.mutedForeground
                )
            }
        }

        Button(
            icon = SHUIIcons.ArrowRight,
            mode = ButtonMode.IconGhost,
        ) {

        }
    }
}