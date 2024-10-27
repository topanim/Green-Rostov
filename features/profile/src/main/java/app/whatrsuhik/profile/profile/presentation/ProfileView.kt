package app.whatrsuhik.profile.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.profile.profile.domain.models.ProfileEvent
import app.whatrsuhik.profile.profile.domain.models.ProfileState
import app.whatrsuhik.profile.profile.presentation.components.Achievement
import app.whatrsuhik.profile.profile.presentation.components.LeaderBoard
import app.whatrsuhik.profile.profile.presentation.components.MyActivity
import app.whatrsuhik.profile.profile.presentation.components.ProfileInfo
import app.whatrsuhik.profile.profile.presentation.components.leaderLick
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.components.topbar.TopAppBar
import app.whatrsuhik.ui.theme.SHUITheme.spacing

@Composable
fun ProfileView(
    state: ProfileState,
    listener: Listener<ProfileEvent>
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(bottom = spacing.sm.dp)
        .padding(horizontal = 20.dp)
) {
    TopAppBar(title = "Профиль")
    VerticalSpace(spacing.lg)
    LazyColumn(
    ) {
        item {

            ProfileInfo("Дарья", "Архипова", "Ростов")
            VerticalSpace(spacing.md)
            MyActivity(state.events)
            VerticalSpace(spacing.md)
            Achievement(state.categories, state.selectedEventIndex ?: 6) { }
            VerticalSpace(spacing.md)
            LeaderBoard()
        }
    }
}

@Preview
@Composable
fun ProfileViewPreview() {
//    ProfileView()
}
