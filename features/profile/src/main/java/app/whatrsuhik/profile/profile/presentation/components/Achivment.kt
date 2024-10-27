package app.whatrsuhik.profile.profile.presentation.components

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
import app.whatrsuhik.profile.profile.domain.models.CategoryItem
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography

@Composable
fun Achievement(
    categories: List<CategoryItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {

    Column {
        Text(
            "Мои достижения",
            style = typography.list,
            color = palettes.foreground
        )
        Space(spacing.lg)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(spacing.md.dp)
        ) {
            itemsIndexed(categories, key = { _, item -> item.title }) { index, item ->
                CategoryBoxItem(
                    painterResource(item.image),
                    item.title,
                    selected = index == selectedItemIndex,
                    onSelect = { onItemSelected(index) }
                )
            }


        }
    }
}

@Composable
fun CategoryBoxItem(
    image: Painter,
    title: String,
    selected: Boolean,
    onSelect: () -> Unit
) =
    Box(
        modifier = Modifier
            .size(80.dp)
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
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = image, "",
                modifier = Modifier.size(36.dp)
            )
            VerticalSpace(spacing.xs)

            Text(
                title, modifier = Modifier.width(78.dp),
                textAlign = TextAlign.Center,
                style = typography.detail,
                color = palettes.foreground

            )
        }

    }


