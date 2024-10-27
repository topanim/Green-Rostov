package app.whatrushik.main.children.general.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.components.YandexMapKit
import app.whatrsuhik.ui.components.widget.CardItem
import app.whatrsuhik.ui.components.widget.PatrolCard
import app.whatrsuhik.ui.components.widget.SearchWidget
import app.whatrsuhik.ui.theme.SHUITheme.isDarkTheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrushik.main.children.general.domain.models.GeneralEvent
import app.whatrushik.main.children.general.domain.models.GeneralState
import app.whatrushik.main.children.general.presentation.components.CategoryBox
import app.whatrushik.main.children.general.presentation.components.UVInfoBlock

@Composable
fun GeneralView(
    state: GeneralState,
    listener: Listener<GeneralEvent>
) = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomCenter
) {
    UVInfoBlock(
        uvIndex = state.uvIndex?.toString() ?: "~",
        modifier = Modifier
            .zIndex(2f)
            .align(Alignment.TopCenter)
            .padding(horizontal = spacing.md.dp)
            .padding(top = spacing.md.dp)
    )

    YandexMapKit(
        darkMode = isDarkTheme,
        points = state.points,
        onResetFocus = { listener(GeneralEvent.OnClearSelection) },
        modifier = Modifier
            .padding(top = spacing.sm.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
    ) { _, point ->
        listener(GeneralEvent.OnMarkClicked(point))
        true
    }

    Column {
        CategoryBox(
            categories = state.categories,
            selectedItemIndex = state.selectedCategoryIndex
        ) { listener(GeneralEvent.OnSelectCategory(it)) }

        if (state.selectedEventIndex != null) {
            val event = state.events[state.selectedEventIndex]

            CardItem(
                id = event.id,
                name = event.name,
                description = event.description,
                picture = event.picture,
                modifier = Modifier.padding(spacing.sm.dp),
                lati = event.latitude,
                long = event.longitude,
                onLongPress = { listener(GeneralEvent.OnClearSelection) },
            ) {
                listener(
                    GeneralEvent.OnEventClicked(
                        event.id,
                        event.name,
                        event.description,
                        event.picture,
                        event.latitude,
                        event.longitude
                    )
                )
            }

        } else if (state.selectedPatrolIndex != null) {
            val patrol = state.patrols[state.selectedPatrolIndex]

            PatrolCard(
                header = patrol.headers,
                onLongPress = { listener(GeneralEvent.OnClearSelection) },
                onParticipate = { listener(GeneralEvent.OnPatrolParticipate(patrol.id)) },
                passing = state.passingPatrol,
                modifier = Modifier
                    .padding(horizontal = spacing.sm.dp)
                    .padding(bottom = spacing.sm.dp),
            )
        } else SearchWidget(
            modifier = Modifier.padding(spacing.sm.dp),
            categories = state.filters,
            selected = state.selectedFilterIndex,
            onSearch = { listener.invoke(GeneralEvent.SearchField(it)) },
            onSelectCategory = { listener.invoke(GeneralEvent.OnSelectFilter(it)) }
        )
    }
}