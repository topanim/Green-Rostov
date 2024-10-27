package app.whatrsuhik.ui.icons


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Sort: ImageVector
    get() {
        if (_Sort != null) {
            return _Sort!!
        }
        _Sort = ImageVector.Builder(
            name = "Candle2",
            defaultWidth = 18.dp,
            defaultHeight = 18.dp,
            viewportWidth = 18f,
            viewportHeight = 18f
        ).apply {
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(17.063f, 13.125f)
                curveTo(17.063f, 13.432f, 16.808f, 13.688f, 16.5f, 13.688f)
                horizontalLineTo(11.25f)
                verticalLineTo(13.875f)
                curveTo(11.25f, 15f, 10.575f, 15.375f, 9.75f, 15.375f)
                horizontalLineTo(5.25f)
                curveTo(4.425f, 15.375f, 3.75f, 15f, 3.75f, 13.875f)
                verticalLineTo(13.688f)
                horizontalLineTo(1.5f)
                curveTo(1.192f, 13.688f, 0.938f, 13.432f, 0.938f, 13.125f)
                curveTo(0.938f, 12.818f, 1.192f, 12.563f, 1.5f, 12.563f)
                horizontalLineTo(3.75f)
                verticalLineTo(12.375f)
                curveTo(3.75f, 11.25f, 4.425f, 10.875f, 5.25f, 10.875f)
                horizontalLineTo(9.75f)
                curveTo(10.575f, 10.875f, 11.25f, 11.25f, 11.25f, 12.375f)
                verticalLineTo(12.563f)
                horizontalLineTo(16.5f)
                curveTo(16.808f, 12.563f, 17.063f, 12.818f, 17.063f, 13.125f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(17.063f, 4.875f)
                curveTo(17.063f, 5.182f, 16.808f, 5.438f, 16.5f, 5.438f)
                horizontalLineTo(14.25f)
                verticalLineTo(5.625f)
                curveTo(14.25f, 6.75f, 13.575f, 7.125f, 12.75f, 7.125f)
                horizontalLineTo(8.25f)
                curveTo(7.425f, 7.125f, 6.75f, 6.75f, 6.75f, 5.625f)
                verticalLineTo(5.438f)
                horizontalLineTo(1.5f)
                curveTo(1.192f, 5.438f, 0.938f, 5.182f, 0.938f, 4.875f)
                curveTo(0.938f, 4.568f, 1.192f, 4.313f, 1.5f, 4.313f)
                horizontalLineTo(6.75f)
                verticalLineTo(4.125f)
                curveTo(6.75f, 3f, 7.425f, 2.625f, 8.25f, 2.625f)
                horizontalLineTo(12.75f)
                curveTo(13.575f, 2.625f, 14.25f, 3f, 14.25f, 4.125f)
                verticalLineTo(4.313f)
                horizontalLineTo(16.5f)
                curveTo(16.808f, 4.313f, 17.063f, 4.568f, 17.063f, 4.875f)
                close()
            }
        }.build()

        return _Sort!!
    }

@Suppress("ObjectPropertyName")
private var _Sort: ImageVector? = null
