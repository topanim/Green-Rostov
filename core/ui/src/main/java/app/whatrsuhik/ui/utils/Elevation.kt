package app.whatrsuhik.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import app.whatrsuhik.ui.theme.SHUITheme.shapes

@Composable
fun Modifier.elevation(value: Dp) = shadow(elevation = value, shape = shapes)