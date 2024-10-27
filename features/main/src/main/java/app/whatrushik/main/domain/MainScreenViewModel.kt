package app.whatrushik.main.domain

import app.whatrsuhik.core.foundation.core.UIController
import app.whatrushik.main.domain.model.MainScreenAction
import app.whatrushik.main.domain.model.MainScreenEvent
import app.whatrushik.main.domain.model.MainScreenState

class MainScreenViewModel : UIController<MainScreenState, MainScreenAction, MainScreenEvent>(
    MainScreenState()
) {
    override fun obtainEvent(viewEvent: MainScreenEvent) = when {
        else -> {}
    }
}