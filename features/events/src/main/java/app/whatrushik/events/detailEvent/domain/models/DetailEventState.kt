package app.whatrushik.events.detailEvent.domain.models

data class DetailEventState(
    val logging: Boolean = false,
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val picture: String = "",
    val longitude: Double = 0.0,
    val latitude: Double = 0.0,

    )
