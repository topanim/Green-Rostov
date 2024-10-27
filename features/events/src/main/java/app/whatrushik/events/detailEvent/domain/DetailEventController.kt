package app.whatrushik.events.detailEvent.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.safeExecute
import app.whatrushik.api_sdk.api.events.IEventsService
import app.whatrushik.api_sdk.shared.dto.Event
import app.whatrushik.events.detailEvent.domain.models.DetailEventAction
import app.whatrushik.events.detailEvent.domain.models.DetailEventEvent
import app.whatrushik.events.detailEvent.domain.models.DetailEventState

class DetailEventController(
    private val eventsService: IEventsService
) : UIController<DetailEventState, DetailEventAction, DetailEventEvent>(
    DetailEventState()
) {
    override fun obtainEvent(viewEvent: DetailEventEvent) = when (viewEvent) {
        is DetailEventEvent.Init -> init(viewEvent)

        DetailEventEvent.BackButtonClicked -> setAction(DetailEventAction.BackButtonClicked)
        DetailEventEvent.ClickButton -> {}
        DetailEventEvent.IsFavoriteButton -> {}
        DetailEventEvent.ShareClicked -> {}
        is DetailEventEvent.OnParticipantClicked -> participateEvent()
    }

    private fun init(viewEvent: DetailEventEvent.Init) {
        updateState {
            copy(
                id = viewEvent.id,
                title = viewEvent.title,
                description = viewEvent.description,
                picture = viewEvent.picture,
                longitude = viewEvent.longitude,
                latitude = viewEvent.latitude
            )
        }
    }

    private fun participateEvent() {
        updateState { copy(logging = true) }
        safeExecute(
            scope = viewModelScope,
            block = {
                eventsService.register(
                    Event.Parameters.Register(eventId = viewState.id)
                )

                safeUpdateState { copy(logging = false) }
            }
        ) {
            Log.d("d", "Error: $it")
        }
    }
}