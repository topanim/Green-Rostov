package app.whatrsuhik.assistant.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.assistant.data.AskAssistantUseCase
import app.whatrsuhik.assistant.domain.models.AssistantAction
import app.whatrsuhik.assistant.domain.models.AssistantEvent
import app.whatrsuhik.assistant.domain.models.AssistantState
import app.whatrsuhik.assistant.domain.models.Message
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.suspendCall

internal class AssistantController(
    private val askAssistantUseCase: AskAssistantUseCase
) : UIController<AssistantState, AssistantAction, AssistantEvent>(
    AssistantState()
) {
    override fun obtainEvent(viewEvent: AssistantEvent) = when (viewEvent) {
        AssistantEvent.Init -> init()
        AssistantEvent.OnStartChattingClicked -> startChatting()

        is AssistantEvent.OnMessageSendClicked -> sendMessage(viewEvent.message)
    }

    private fun init() {}

    private fun startChatting() = updateState {
        copy(
            isChatStarted = true,
            messages = listOf(
                Message(
                    authorIsMe = false,
                    content = "Привет! Чем я могу помочь?"
                )
            )
        )
    }

    private fun sendMessage(message: String) {
        updateState {
            copy(
                isAiThinking = true,
                messages = messages + Message(
                    authorIsMe = true,
                    content = message
                )
            )
        }

        suspendCall(viewModelScope) {
            val questionResult = askAssistantUseCase.execute(message)
            val newMessage = if (questionResult.isSuccess)
                Message(authorIsMe = false, content = questionResult.getOrThrow().answer)
            else {
                Log.d("d", "Error: ${questionResult.exceptionOrNull()}")
                Message(authorIsMe = false, content = "Произошла ошибка, попробуйте еще раз")
            }

            safeUpdateState {
                copy(
                    messages = messages + newMessage,
                    isAiThinking = false
                )
            }
        }
    }
}
