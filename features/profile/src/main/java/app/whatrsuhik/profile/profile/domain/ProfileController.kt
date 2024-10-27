package app.whatrsuhik.profile.profile.domain

import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.profile.profile.domain.models.ProfileAction
import app.whatrsuhik.profile.profile.domain.models.ProfileEvent
import app.whatrsuhik.profile.profile.domain.models.ProfileState

class ProfileController : UIController<ProfileState, ProfileAction, ProfileEvent>(
    ProfileState()
) {
    override fun obtainEvent(viewEvent: ProfileEvent) = when (viewEvent) {
        ProfileEvent.Init -> init()
    }

    private fun init() {}
}
