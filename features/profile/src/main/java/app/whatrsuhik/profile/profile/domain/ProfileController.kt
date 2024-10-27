package app.whatrsuhik.profile.profile.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.safeExecute
import app.whatrsuhik.profile.profile.domain.models.ProfileAction
import app.whatrsuhik.profile.profile.domain.models.ProfileEvent
import app.whatrsuhik.profile.profile.domain.models.ProfileState
import app.whatrushik.api_sdk.api.events.IEventsService
import app.whatrushik.api_sdk.api.patrol.IPatrolService
import app.whatrushik.api_sdk.shared.dto.Event

class ProfileController(
    private val service: IPatrolService,
    private val dataEvent:IEventsService
) : UIController<ProfileState, ProfileAction, ProfileEvent>(
    ProfileState()
) {
    override fun obtainEvent(viewEvent: ProfileEvent) = when (viewEvent) {
        ProfileEvent.Init -> init()
        ProfileEvent.Achievement -> {}
        ProfileEvent.MyActivity -> getActivity()
        ProfileEvent.Profile -> {}
    }

    private fun init() {}

    private fun getActivity() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val data = dataEvent.my(Event.Parameters.My())

                updateState { copy(events = data) }


            }
        ) {
            Log.d("d", "Error: $it")
        }

    }


}
