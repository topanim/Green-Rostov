package app.whatrushik.what_shadcn_ui.core.react

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


val openState
    @Composable
    get() = LocalOpenState.current

val setOpenState
    @Composable
    get() = LocalSetOpenState.current


internal val LocalOpenState =
    staticCompositionLocalOf<Boolean> { error("LocalOpenState not provided") }

internal val LocalSetOpenState =
    staticCompositionLocalOf<(Boolean) -> Unit> { error("LocalSetOpenState not provided") }


@Composable
fun ProvideOpenState(
    open: Boolean,
    setOpen: (Boolean) -> Unit,
    content: @Composable () -> Unit
) = CompositionLocalProvider(
    LocalOpenState provides open,
    LocalSetOpenState provides setOpen,
    content = content
)