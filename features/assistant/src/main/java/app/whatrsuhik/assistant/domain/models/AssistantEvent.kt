package app.whatrsuhik.assistant.domain.models

sealed interface AssistantEvent {
    data object Init : AssistantEvent

    data object OnStartChattingClicked : AssistantEvent
    data class OnMessageSendClicked(val message: String) : AssistantEvent
}
