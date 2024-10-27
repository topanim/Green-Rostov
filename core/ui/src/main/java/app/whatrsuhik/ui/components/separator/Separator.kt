package app.whatrsuhik.ui.components.separator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUITheme.palettes

@Composable
private fun Modifier.separatorCommonModifier() = background(palettes.border)

@Composable
fun ColumnScope.Separator(modifier: Modifier = Modifier) = Spacer(
    modifier = modifier
        .fillMaxWidth()
        .height(1.dp)
        .separatorCommonModifier()
)

@Composable
fun RowScope.Separator(modifier: Modifier = Modifier) = Spacer(
    modifier = modifier
        .fillMaxHeight()
        .width(1.dp)
        .separatorCommonModifier()
)