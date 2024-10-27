package app.whatrsuhik.profile.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrushik.api_sdk.shared.dto.Event


@Composable
fun MyActivity(
    list: List<Event.Responses.Event>
) = Column {
    Text(
        "Участвую",
        style = SHUITheme.typography.list,
        color = SHUITheme.palettes.foreground
    )

    Space(spacing.lg)

    LazyColumn {
//        items(list) {
//            CardItem(it., {}) {

//            }
//        }
    }
}