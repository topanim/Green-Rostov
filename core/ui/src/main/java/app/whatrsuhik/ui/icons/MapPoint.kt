package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIIcons

val SHUIIcons.MapPoint: ImageVector
    get() {
        if (_MapPoint != null) {
            return _MapPoint!!
        }
        _MapPoint = ImageVector.Builder(
            name = "Vector",
            defaultWidth = 18.dp,
            defaultHeight = 21.dp,
            viewportWidth = 18f,
            viewportHeight = 21f
        ).apply {
            path(fill = SolidColor(Color(0xFF2A9E66))) {
                moveTo(17.62f, 6.961f)
                curveTo(16.57f, 2.315f, 12.54f, 0.223f, 9f, 0.223f)
                curveTo(9f, 0.223f, 9f, 0.223f, 8.99f, 0.223f)
                curveTo(5.46f, 0.223f, 1.42f, 2.305f, 0.37f, 6.951f)
                curveTo(-0.8f, 12.141f, 2.36f, 16.535f, 5.22f, 19.301f)
                curveTo(6.28f, 20.327f, 7.64f, 20.84f, 9f, 20.84f)
                curveTo(10.36f, 20.84f, 11.72f, 20.327f, 12.77f, 19.301f)
                curveTo(15.63f, 16.535f, 18.79f, 12.151f, 17.62f, 6.961f)
                close()
                moveTo(9f, 12f)
                curveTo(7.26f, 12f, 5.85f, 10.582f, 5.85f, 8.832f)
                curveTo(5.85f, 7.082f, 7.26f, 5.664f, 9f, 5.664f)
                curveTo(10.74f, 5.664f, 12.15f, 7.082f, 12.15f, 8.832f)
                curveTo(12.15f, 10.582f, 10.74f, 12f, 9f, 12f)
                close()
            }
        }.build()

        return _MapPoint!!
    }

@Suppress("ObjectPropertyName")
private var _MapPoint: ImageVector? = null
