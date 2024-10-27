package app.whatrushik.events.createEvent.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import app.whatrsuhik.core.foundation.core.Listener
import app.whatrsuhik.ui.components.YandexSelectPositionMap
import app.whatrsuhik.ui.components.button.Button
import app.whatrsuhik.ui.components.button.ButtonMode
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.topbar.TopAppBar
import app.whatrsuhik.ui.components.widget.BaseTextField
import app.whatrsuhik.ui.components.widget.CategoryFieldsBox
import app.whatrsuhik.ui.icons.ArrowLeftRight
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.isDarkTheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.utils.OnKeyboardHiddenListener
import app.whatrushik.core.navigation.core.rememberNavigator
import app.whatrushik.events.createEvent.domain.models.CreateEventEvent
import app.whatrushik.events.createEvent.domain.models.CreateEventState
import app.whatrushik.what_shadcn_ui.core.react.useState

@Composable
fun CreateEventView(
    state: CreateEventState,
    listener: Listener<CreateEventEvent>
) {
    val navigator = rememberNavigator()
    val focusManager = LocalFocusManager.current

    val (title, setTitle) = useState(state.title)
    val (category, setCategory) = useState(state.category)
    val (description, setDescription) = useState(state.description)
    val (startDate, setStartDate) = useState(state.startDate)
    val (endDate, setEndDate) = useState(state.endDate)
    val (address, setAddress) = useState(state.address)

    val updateAll = {
        listener(
            CreateEventEvent.OnFocusTakenOff(
                title, category, description,
                startDate, endDate, address
            )
        )
    }

    OnKeyboardHiddenListener {
        updateAll()
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = spacing.md.dp)
            .padding(top = spacing.lg.dp)
            .padding(bottom = spacing.md.dp)
            .padding(
                WindowInsets.systemBars
                    .only(WindowInsetsSides.Vertical)
                    .asPaddingValues()
            )
            .onFocusChanged {
                if (!it.hasFocus) updateAll()
            }
    ) {
        Column {
            TopAppBar(
                title = "Создание мероприятия",
                onBackPress = navigator.c::popBackStack
            )

            CategoryFieldsBox(
                icon = SHUIIcons.ArrowLeftRight,
                title = "Заполните описание мероприятиея:",
            ) {
                BaseTextField(
                    value = title,
                    onValueChange = setTitle,
                    placeholder = "Название"
                )

                Space(spacing.xs)

                BaseTextField(
                    value = category,
                    onValueChange = setCategory,
                    placeholder = "Категория"
                )

                Space(spacing.xs)

                BaseTextField(
                    value = description,
                    onValueChange = setDescription,
                    placeholder = "Описание"
                )

                Space(spacing.xs)
            }

            CategoryFieldsBox(
                icon = SHUIIcons.ArrowLeftRight,
                title = "Заполните подробности о мероприятии:",
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BaseTextField(
                        modifier = Modifier.weight(1f),
                        value = startDate,
                        onValueChange = setStartDate,
                        placeholder = "Дата начала"
                    )

                    Space(spacing.md)

                    BaseTextField(
                        modifier = Modifier.weight(1f),
                        value = endDate,
                        onValueChange = setEndDate,
                        placeholder = "Дата окончания"
                    )
                }

                YandexSelectPositionMap(
                    darkMode = isDarkTheme,
                    point = address,
                    setPoint = setAddress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(SHUIShapes.Large)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                label = "Отменить",
                mode = ButtonMode.Secondary,
                modifier = Modifier.weight(1f)
            ) { listener(CreateEventEvent.CancelCreationClicked) }

            Space(spacing.md)

            Button(
                label = "Сохранить",
                modifier = Modifier.weight(1f)
            ) { listener(CreateEventEvent.SaveEventClicked) }
        }
    }
}