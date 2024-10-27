package app.whatrsuhik.profile.profile.domain.models

sealed interface ProfileEvent {
    data object Init : ProfileEvent
    data object MyActivity:ProfileEvent
    data object Profile:ProfileEvent
    data object Achievement:ProfileEvent
}
