package app.whatrsuhik.assistant.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrsuhik.assistant.domain.models.AssistantEvent
import app.whatrsuhik.assistant.domain.models.AssistantState
import app.whatrsuhik.assistant.presentation.components.ChatField
import app.whatrsuhik.assistant.presentation.components.EmptyChatStub
import app.whatrsuhik.assistant.presentation.components.MessageView
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.topbar.TopAppBar
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrushik.what_shadcn_ui.core.react.useState

@Composable
internal fun AssistantView(
    state: AssistantState,
    listener: Listener<AssistantEvent>
) {
    val (messageText, setMessageText) = useState(state.messageText)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if (!state.isChatStarted) {
            EmptyChatStub { listener(AssistantEvent.OnStartChattingClicked) }
        } else {
            TopAppBar(
                title = "Ассистент-эколог",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.sm.dp)
                    .padding(top = spacing.lg.dp, bottom = spacing.sm.dp)
            )

            Space(spacing.sm)

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(spacing.sm.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = spacing.sm.dp)
            ) {
                items(state.messages, key = { it.id }) {
                    MessageView(message = it)
                }
            }

            ChatField(
                placeholder = "Напишите что-нибудь...",
                value = messageText,
                onValueChange = setMessageText,
                isIdle = state.isAiThinking,
                onSend = { listener(AssistantEvent.OnMessageSendClicked(it)) }
            )
        }
    }
}
