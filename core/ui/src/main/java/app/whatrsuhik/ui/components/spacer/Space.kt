package app.whatrsuhik.ui.components.spacer

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.Space(size: Int, modifier: Modifier = Modifier) =
    VerticalSpace(size = size, modifier = modifier)

@Composable
fun RowScope.Space(size: Int, modifier: Modifier = Modifier) =
    HorizontalSpace(size = size, modifier = modifier)

@Composable
fun HorizontalSpace(size: Int, modifier: Modifier = Modifier) = Spacer(
    modifier = Modifier
        .width(size.dp)
        .then(modifier)
)

@Composable
fun VerticalSpace(size: Int, modifier: Modifier = Modifier) = Spacer(
    modifier = Modifier
        .height(size.dp)
        .then(modifier)
)

