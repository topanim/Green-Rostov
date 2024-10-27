package app.whatrsuhik.ui.components.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import app.whatrsuhik.ui.icons.X
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrushik.what_shadcn_ui.core.react.useState

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    BaseTextField(
        value = value,
        placeholder = "введите текст для поиска",
        onValueChange = onValueChange,
        options = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        actions = KeyboardActions {
            onSearch(value)
            focusManager.clearFocus()
        },
        leading = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = palettes.mutedForeground,
                contentDescription = ""
            )
        },
        trailing = {
            if (value.isNotEmpty()) {
                Icon(
                    imageVector = SHUIIcons.X,
                    contentDescription = "clear",
                    tint = palettes.mutedForeground,
                    modifier = Modifier
                        .clip(SHUIShapes.Circle)
                        .clickable { onValueChange("") }
                )
            }
        }
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    val (value, setValue) = useState("")
    SearchBar(value, setValue) {}
}