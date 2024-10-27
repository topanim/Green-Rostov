package app.whatrsuhik.profile.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.components.widget.CardItem
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrushik.api_sdk.shared.dto.Event
import app.whatrushik.api_sdk.shared.dto.Patrol


@Composable
fun MyActivity(
    list: List<Event.Responses.Event>
) = Column {

    Text(
        "Участвую",
        style = SHUITheme.typography.list,
        color = SHUITheme.palettes.foreground
    )

    VerticalSpace(spacing.lg)

    list.forEach {
        CardItem(
            name = it.name,
            picture = it.picture,
            description = it.description,
            long = it.longitude,
            lati = it.latitude,
            id = it.id
        ) { }
        VerticalSpace(spacing.sm)
    }
}

