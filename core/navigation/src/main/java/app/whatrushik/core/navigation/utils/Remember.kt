package app.whatrushik.core.navigation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun <T> T.remember(): T = remember { this }