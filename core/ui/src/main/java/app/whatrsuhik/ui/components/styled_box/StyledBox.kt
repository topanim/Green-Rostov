package app.whatrsuhik.ui.components.styled_box

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.shapes

@Composable
fun StyledBox(
    modifier: Modifier = Modifier,
    shape: Shape? = null,
    content: @Composable BoxScope.() -> Unit
) = Box(
    contentAlignment = Alignment.Center,
    content = content,
    modifier = Modifier
        .clip(shape ?: shapes)
        .border(1.dp, palettes.border, shape ?: shapes)
        .then(modifier)
)