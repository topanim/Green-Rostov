package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Home2: ImageVector
    get() {
        if (_Home2 != null) {
            return _Home2!!
        }
        _Home2 = ImageVector.Builder(
            name = "Home2",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF73C76E))) {
                moveTo(20.04f, 6.82f)
                lineTo(14.28f, 2.79f)
                curveTo(12.71f, 1.69f, 10.3f, 1.75f, 8.79f, 2.92f)
                lineTo(3.78f, 6.83f)
                curveTo(2.78f, 7.61f, 1.99f, 9.21f, 1.99f, 10.47f)
                verticalLineTo(17.37f)
                curveTo(1.99f, 19.92f, 4.06f, 22f, 6.61f, 22f)
                horizontalLineTo(17.39f)
                curveTo(19.94f, 22f, 22.01f, 19.93f, 22.01f, 17.38f)
                verticalLineTo(10.6f)
                curveTo(22.01f, 9.25f, 21.14f, 7.59f, 20.04f, 6.82f)
                close()
                moveTo(12.75f, 18f)
                curveTo(12.75f, 18.41f, 12.41f, 18.75f, 12f, 18.75f)
                curveTo(11.59f, 18.75f, 11.25f, 18.41f, 11.25f, 18f)
                verticalLineTo(15f)
                curveTo(11.25f, 14.59f, 11.59f, 14.25f, 12f, 14.25f)
                curveTo(12.41f, 14.25f, 12.75f, 14.59f, 12.75f, 15f)
                verticalLineTo(18f)
                close()
            }
        }.build()

        return _Home2!!
    }

@Suppress("ObjectPropertyName")
private var _Home2: ImageVector? = null


