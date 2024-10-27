package app.whatrushik.events.detailEvent.presentation

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.button.ButtonMode
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.components.topbar.TopAppBar
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.utils.decodeBase64ToBitmap
import app.whatrushik.events.detailEvent.domain.models.DetailEventEvent
import app.whatrushik.events.detailEvent.domain.models.DetailEventState
import app.whatrushik.events.detailEvent.presentation.component.AboutEvent
import app.whatrushik.events.detailEvent.presentation.component.DateTimeDescription
import app.whatrushik.events.detailEvent.presentation.component.DescriptionEvent

@Composable
fun DetailEventView(
    state: DetailEventState,
    listener: Listener<DetailEventEvent>
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(
            WindowInsets.systemBars
                .only(WindowInsetsSides.Vertical)
                .asPaddingValues()
        ),
) {

    TopAppBar(
        modifier = Modifier.padding(start = spacing.xs.dp),
        title = state.title,
        trailing = {
            TrailingIcons({}, {})
        },
        onBackPress = {
            listener.invoke(DetailEventEvent.BackButtonClicked)
        })

    var decodedPicture: Bitmap? by remember { mutableStateOf(null) }

    LaunchedEffect(state.picture) {
        decodedPicture = decodeBase64ToBitmap(state.picture)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)

    ) {
        item {
            VerticalSpace(spacing.xs)

            decodedPicture?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(242.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            VerticalSpace(spacing.lg)
            DateTimeDescription(state.title, state.latitude, state.longitude)

            VerticalSpace(spacing.md)
            HorizontalDivider(color = SHUITheme.palettes.muted)

            VerticalSpace(spacing.lg)
            DescriptionEvent(state.description)

            HorizontalDivider(color = SHUITheme.palettes.muted)
            VerticalSpace(spacing.lg)
        }

    }
    Box(modifier = Modifier.fillMaxSize().padding(bottom = spacing.lg.dp).padding(horizontal = 20.dp),
        contentAlignment = Alignment.BottomCenter) {
        Button(
            fill = true,
            label = "Участвую"
        ) { listener(DetailEventEvent.OnParticipantClicked(state.id)) }
    }
}


@Composable
fun TrailingIcons(onFavorite: () -> Unit, share: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        IconButton({

        }) {
            Icon(Icons.Default.Share, "")
        }

    }
}


