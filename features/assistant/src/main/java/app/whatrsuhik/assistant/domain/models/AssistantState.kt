package app.whatrsuhik.assistant.domain.models

import java.util.UUID

data class AssistantState(
    val messageText: String = "",
    val messages: List<Message> = emptyList(),
    val isAiThinking: Boolean = false,
    val isChatStarted: Boolean = messages.isNotEmpty()
)

data class Message(
    val authorIsMe: Boolean,
    val content: String
) {
    val id = UUID.randomUUID()
}
