package app.whatrushik.main.children.general.domain.models

import androidx.annotation.DrawableRes
import app.whatrsuhik.ui.R
import app.whatrushik.api_sdk.shared.dto.Event
import app.whatrushik.api_sdk.shared.dto.Patrol
import com.yandex.mapkit.geometry.Point

data class GeneralState(
    val selectedFilterIndex: Int = 0,
    val selectedCategoryIndex: Int = 0,
    val selectedEventIndex: Int? = null,
    val selectedPatrolIndex: Int? = null,
    val points: List<Point> = emptyList(),

    val passingPatrol: Boolean = false,
    val uvIndex: Float? = null,
    val filters: List<String> = listOf("Высокий рейтинг", "Ближайшие"),
    val patrols: List<Patrol.Responses.Patrol> = emptyList(),
    val events: List<Event.Responses.Event> = emptyList(),
    val marksLoadingState: Loading = Loading.IsLoading,
    val categories: List<CategoryItem> = listOf(
        CategoryItem(
            image = R.drawable.frame1,
            title = "Эко-патрули"
        ),
        CategoryItem(
            image = R.drawable.frame2,
            title = "Мероприятия"
        ),
        CategoryItem(
            image = R.drawable.frame3,
            title = "Эко-шопы"
        ),
        CategoryItem(
            image = R.drawable.frame4,
            title = "Пункты переработки"
        )
    )
)

data class CategoryItem(
    @DrawableRes val image: Int,
    val title: String
)

sealed interface Loading {
    data object IsLoaded : Loading
    data object IsLoading : Loading
    data object Error : Loading
}
