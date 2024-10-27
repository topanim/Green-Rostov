package app.whatrsuhik.profile.profile.domain.models

import androidx.annotation.DrawableRes
import app.whatrsuhik.ui.R
import app.whatrushik.api_sdk.shared.dto.Event

data class ProfileState(
    val selectedCategoryIndex: Int = 0,
    val selectedEventIndex: Int? = null,
    val events: List<Event.Responses.Event> = emptyList(),
    val categories: List<CategoryItem> = listOf(
        CategoryItem(
            image = R.drawable.profile_frame,
            title = "Синий войн"
        ),
        CategoryItem(
            image = R.drawable.profile_frame2,
            title = "Эко-новатор"
        ),
        CategoryItem(
            image = R.drawable.profile_frame3,
            title = "Хранитель планеты"
        ),
        CategoryItem(
            image = R.drawable.profile_frame4,
            title = "Эко-герой"
        )
    )
)

data class CategoryItem(
    @DrawableRes val image: Int,
    val title: String
)


