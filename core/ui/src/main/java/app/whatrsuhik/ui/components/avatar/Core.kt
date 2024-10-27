package app.whatrsuhik.ui.components.avatar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIShapes

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) = Box(
    contentAlignment = Alignment.Center,
    content = content,
    modifier = modifier
        .size(64.dp)
        .clip(SHUIShapes.Circle)
)