package app.whatrsuhik.ui.components.alert

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.styled_box.StyledBox
import app.whatrsuhik.ui.theme.SHUITheme.spacing

@Composable
fun Alert(
    modifier: Modifier = Modifier,
    leading: @Composable (Modifier) -> Unit = {},
    title: @Composable (Modifier) -> Unit,
    description: @Composable (Modifier) -> Unit = {},
    trailing: @Composable (Modifier) -> Unit = {},
) = StyledBox(modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .padding(spacing.md.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        leading(Modifier)
        Space(spacing.sm)
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                title(Modifier)
                Space(spacing.xs)
                description(Modifier)
            }
            Space(spacing.sm)
            trailing(Modifier)
        }
    }
}