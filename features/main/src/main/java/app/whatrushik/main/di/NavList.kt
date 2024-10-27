package app.whatrushik.main.di

import app.whatrsuhik.assistant.navigation.AssistantProvider
import app.whatrsuhik.profile.profile.navigation.ProfileProvider
import app.whatrsuhik.ui.icons.Assistant
import app.whatrsuhik.ui.icons.Blur
import app.whatrsuhik.ui.icons.CalendarTick
import app.whatrsuhik.ui.icons.Home2
import app.whatrsuhik.ui.icons.User
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrushik.core.navigation.bottom_navigation.navItem
import app.whatrushik.events.events.navigation.EventsProvider
import app.whatrushik.main.children.expenses.navigation.ExpensesProvider
import app.whatrushik.main.children.general.navigation.GeneralProvider

internal val navList = listOf(
    navItem(
        name = "Главная",
        icon = Home2,
        provider = GeneralProvider
    ),
    navItem(
        name = "Расходы",
        icon = Blur,
        provider = ExpensesProvider
    ),
    navItem(
        name = "События",
        icon = CalendarTick,
        provider = EventsProvider
    ),
    navItem(
        name = "Ассистент",
        icon = Assistant,
        provider = AssistantProvider
    ),
    navItem(
        name = "Профиль",
        icon = SHUIIcons.User,
        provider = ProfileProvider
    )
)