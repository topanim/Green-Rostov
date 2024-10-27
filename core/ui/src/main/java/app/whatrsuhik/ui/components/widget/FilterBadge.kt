package app.whatrsuhik.ui.components.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.HorizontalSpace
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.palettes

@Composable
fun FilterBadge(filterName: List<String>, selected: Int, onSelected: (Int) -> Unit) {

    LazyRow {
        itemsIndexed(filterName) { index, item ->
            BadgeTab(item, index, selected) {
                onSelected(index)
            }

            HorizontalSpace(10)
        }
    }
}

@Composable
fun BadgeTab(
    title: String,
    currentIndex: Int,
    selected: Int,
    onClick: () -> Unit
) {
    val background =
        if (currentIndex == selected) palettes.primary
        else palettes.muted

    val foreground =
        if (currentIndex == selected) palettes.primaryForeground
        else palettes.mutedForeground

    Box(
        modifier = Modifier
            .clip(SHUIShapes.Small)
            .background(background)
            .border(width = 1.dp, shape = SHUIShapes.Small, color = background)
            .clickable(onClick = onClick)
    ) {
        Text(
            title,
            modifier = Modifier.padding(8.dp),
            style = SHUITheme.typography.small,
            color = foreground
        )
    }
}