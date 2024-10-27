package app.whatrushik.events.detailEvent.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.icons.CalendarTick
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.utils.GeocoderUtil

@Composable
fun DateTimeDescription(title: String, latitude: Double, longitude: Double) = Row(
    Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        text = GeocoderUtil.getAddressFromCoordinates(context, latitude.toString(), longitude.toString())

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),

        ) {
            IconColumn("30 октября, 12:00", CalendarTick)
            Space(spacing.sm)
            IconColumn(text, Icons.Default.Place)
        }
    }
}

@Composable
fun IconColumn(title: String, icon: ImageVector) {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,) {
        Icon(
            imageVector = icon, "",
            Modifier.size(24.dp),
            tint = palettes.foreground
        )
        Space(5)
        Text(
            title,
            style = SHUITheme.typography.bodyMedium,
            textAlign = TextAlign.Start,
            color = palettes.mutedForeground,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


