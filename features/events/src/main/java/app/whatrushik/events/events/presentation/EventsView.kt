package app.whatrushik.events.events.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.topbar.TopAppBar
import app.whatrsuhik.ui.components.widget.CardItem
import app.whatrsuhik.ui.components.widget.SearchBar
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrushik.events.events.domain.models.EventsEvent
import app.whatrushik.events.events.domain.models.EventsState
import app.whatrushik.events.events.presentation.components.CategoryBadge


@Composable
fun EventsView(
    state: EventsState,
    listener: Listener<EventsEvent>
) = Column(
    verticalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = spacing.sm.dp)
        .padding(
            WindowInsets
                .systemBars
                .only(WindowInsetsSides.Top)
                .asPaddingValues()
        )
) {

    TopAppBar(title = "Мероприятия")

    Space(spacing.md)

    SearchBar("", {}) { }

    Space(spacing.md)

    CategoryBadge()

    Space(spacing.md)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = spacing.lg.dp)
    ) {
        LazyColumn(
            Modifier.weight(1f)
        ) {
            items(state.events) {
                CardItem(
                    id = it.id,
                    name = it.name,
                    description = it.description,
                    picture = it.picture,
                    lati = it.latitude,
                    long = it.longitude
                ) {
                    listener.invoke(
                        EventsEvent.NavigateToDetail(
                            it.id,
                            it.name,
                            it.description,
                            it.picture,
                            it.latitude,
                            it.longitude
                        )
                    )
                }
                Space(spacing.sm)
            }

        }
        Button(
            fill = true,
            label = "Создать мероприятие"
        ) { listener.invoke(EventsEvent.ClickButton) }

        Space(spacing.sm)


    }
}

