package app.whatrushik.splash.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.suspendCall
import app.whatrushik.domain.impl.isUserAuthorized.IIsUserAuthorisedUseCase
import app.whatrushik.splash.domain.models.SplashAction
import app.whatrushik.splash.domain.models.SplashEvent
import app.whatrushik.splash.domain.models.SplashState
import kotlinx.coroutines.delay

class SplashController(
    private val isUserAuthorizedUseCase: IIsUserAuthorisedUseCase
) : UIController<SplashState, SplashAction, SplashEvent>(
    SplashState()
) {
    override fun obtainEvent(viewEvent: SplashEvent) = when (viewEvent) {
        SplashEvent.Init -> init()
    }

    private fun init() {
        suspendCall(viewModelScope) {
            delay(3000L)

            if (isUserAuthorizedUseCase.execute()) {
                Log.d("d", "1")
                setAction(SplashAction.NavigateToMain)
            } else {
                Log.d("d", "2")
                setAction(SplashAction.NavigateToLogin)
            }
        }

    }
}
