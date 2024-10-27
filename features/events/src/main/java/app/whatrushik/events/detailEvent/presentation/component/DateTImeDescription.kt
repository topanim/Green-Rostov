package app.whatrushik.events.detailEvent.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.icons.CalendarTick
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.palettes

@Composable
fun DateTimeDescription() = Row(
    Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Column {
        Text(
            "Субботник",
            style = SHUITheme.typography.bodyMedium,
            color = palettes.primary
        )
        Space(2)
        Text(
            "Зеленый день",
            style = SHUITheme.typography.list,
            color = palettes.foreground
        )
    }
    Column {
        IconColumn("30 октября,12:00", CalendarTick)
        Space(12)
        IconColumn("Парк \"Левобережный\"", Icons.Default.Place)
    }
}

@Composable
fun IconColumn(title: String, icon: ImageVector) {
    Row {
        Icon(
            imageVector = icon, "",
            Modifier.size(24.dp),
            tint = palettes.background
        )
        Space(5)
        Text(
            title,
            style = SHUITheme.typography.bodyMedium,
            color = palettes.mutedForeground
        )
    }
}


