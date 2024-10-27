package app.whatrushik.events.events.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.safeExecute
import app.whatrushik.domain.impl.getEvents.IGetEventsUseCase
import app.whatrushik.events.events.domain.models.EventsAction
import app.whatrushik.events.events.domain.models.EventsEvent
import app.whatrushik.events.events.domain.models.EventsState

class EventsController(
    private val getEventsUseCase: IGetEventsUseCase
) : UIController<EventsState, EventsAction, EventsEvent>(
    EventsState()
) {
    override fun obtainEvent(viewEvent: EventsEvent) = when (viewEvent) {
        is EventsEvent.NavigateToDetail -> setAction(EventsAction.NavigateToDetail(
            viewEvent.id,
            viewEvent.title,
            viewEvent.description,
            viewEvent.picture,
            viewEvent.latitude,
            viewEvent.longitude
        ))
        EventsEvent.ClickButton -> setAction(EventsAction.NavigateToCreate)
        EventsEvent.FetchAllData -> fetchData()
        EventsEvent.Init -> {}
    }

    private fun fetchData() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val request = getEventsUseCase.execute()
                Log.i("list", request.toString())
                updateState { copy(events = request) }

            }
        ) {
            Log.d("exx", it.toString())
        }

    }
}
