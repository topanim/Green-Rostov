package app.whatrushik.main.children.general.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.HorizontalSpace
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography
import app.whatrushik.main.children.general.domain.models.CategoryItem

@Composable
fun CategoryBox(
    categories: List<CategoryItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) = LazyRow(
    horizontalArrangement = Arrangement.spacedBy(spacing.md.dp)
) {
    item { HorizontalSpace(spacing.none) }

    itemsIndexed(categories, key = { _, item -> item.title }) { index, item ->
        CategoryBoxItem(
            painterResource(item.image),
            item.title,
            selected = index == selectedItemIndex,
            onSelect = { onItemSelected(index) }
        )
    }

    item { HorizontalSpace(spacing.none) }
}


@Composable
fun CategoryBoxItem(
    image: Painter,
    title: String,
    selected: Boolean,
    onSelect: () -> Unit
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Box(
        modifier = Modifier
            .size(78.dp)
            .clip(SHUIShapes.Medium)
            .clickable(enabled = !selected, onClick = onSelect)
            .border(
                1.dp,
                if (selected) palettes.primary
                else palettes.border,
                SHUIShapes.Medium
            )
            .background(palettes.secondary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image, "",
            modifier = Modifier.size(52.dp)
        )
    }

    Space(spacing.xs)

    Text(
        title, modifier = Modifier.width(78.dp),
        textAlign = TextAlign.Center,
        style = typography.detail,
        color = palettes.foreground
    )
}
