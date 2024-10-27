package app.whatrushik.events.events.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.badge.Badge
import app.whatrsuhik.ui.components.badge.BadgeMode
import app.whatrsuhik.ui.components.spacer.HorizontalSpace
import app.whatrsuhik.ui.icons.Sort

@Composable
fun CategoryBadge() {
    val test = listOf("Все", "Категория", "Категория", "Категория", "Категория")
    LazyRow {
        item {
            var isSelected by remember { mutableStateOf(false) }
            Badge(
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 7.dp),
                mode = if (isSelected) BadgeMode.Default else BadgeMode.Outline,
            ) {
                Icon(
                    Sort, "",
                    modifier = Modifier.size(18.dp)
                )
            }
            HorizontalSpace(10)
        }

        items(test) {
            BadgeItem(it)
            HorizontalSpace(10)
        }
    }


}

@Composable
fun BadgeItem(title: String) {
    var isSelected by remember { mutableStateOf(false) }
    Badge(
        modifier = Modifier
            .padding(1.dp)
            .clickable {
                isSelected = !isSelected
            },
        mode = if (isSelected) BadgeMode.Default else BadgeMode.Outline,
        text = title
    )
}

@Preview
@Composable
fun BadgePreview() {
    CategoryBadge()
}