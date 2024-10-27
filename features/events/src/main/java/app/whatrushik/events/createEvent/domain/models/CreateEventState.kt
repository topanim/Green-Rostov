package app.whatrushik.events.createEvent.domain.models

import app.whatrsuhik.ui.components.MapDefaults
import com.yandex.mapkit.geometry.Point

data class CreateEventState(
    val title: String = "",
    val category: String = "",
    val description: String = "",
    val startDate: String = "",
    val endDate: String = "",
    val address: Point = MapDefaults.RostovOnDon,
)
