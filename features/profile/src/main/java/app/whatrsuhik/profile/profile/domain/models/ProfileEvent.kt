package app.whatrsuhik.profile.profile.domain.models

sealed interface ProfileEvent {
    data object Init : ProfileEvent
}
