package app.whatrushik.events.createEvent.domain

import app.whatrsuhik.core.foundation.core.UIController
import app.whatrushik.events.createEvent.domain.models.CreateEventAction
import app.whatrushik.events.createEvent.domain.models.CreateEventEvent
import app.whatrushik.events.createEvent.domain.models.CreateEventState

class CreateEventController : UIController<CreateEventState, CreateEventAction, CreateEventEvent>(
    CreateEventState()
) {
    override fun obtainEvent(viewEvent: CreateEventEvent) = when (viewEvent) {
        CreateEventEvent.Init -> init()
        is CreateEventEvent.OnFocusTakenOff -> updateAll(viewEvent)
        CreateEventEvent.SaveEventClicked -> createEvent()
        CreateEventEvent.CancelCreationClicked -> cancelCreation()
    }

    private fun init() {}

    private fun updateAll(viewEvent: CreateEventEvent.OnFocusTakenOff) = updateState {
        copy(
            title = viewEvent.title,
            category = viewEvent.category,
            description = viewEvent.description,
            startDate = viewEvent.startDate,
            endDate = viewEvent.endDate,
            address = viewEvent.address
        )
    }

    private fun createEvent() {}
    private fun cancelCreation() {}
}
