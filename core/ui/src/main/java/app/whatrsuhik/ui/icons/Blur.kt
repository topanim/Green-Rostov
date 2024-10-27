package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Blur: ImageVector
    get() {
        if (_Blur != null) {
            return _Blur!!
        }
        _Blur = ImageVector.Builder(
            name = "Blur",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(13.47f, 7.41f)
                lineTo(15.93f, 6.2f)
                curveTo(16.23f, 6.05f, 16.31f, 5.66f, 16.08f, 5.42f)
                curveTo(15.19f, 4.44f, 14.29f, 3.62f, 13.57f, 3f)
                curveTo(13.24f, 2.72f, 12.75f, 2.95f, 12.75f, 3.38f)
                verticalLineTo(6.96f)
                curveTo(12.75f, 7.33f, 13.14f, 7.57f, 13.47f, 7.41f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(12.75f, 19.74f)
                verticalLineTo(21.39f)
                curveTo(12.75f, 21.69f, 13.02f, 21.94f, 13.32f, 21.89f)
                curveTo(16.05f, 21.44f, 18.33f, 19.61f, 19.41f, 17.15f)
                curveTo(19.6f, 16.73f, 19.14f, 16.31f, 18.72f, 16.51f)
                lineTo(13.03f, 19.3f)
                curveTo(12.86f, 19.38f, 12.75f, 19.55f, 12.75f, 19.74f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(11.25f, 3.36f)
                curveTo(11.25f, 2.93f, 10.76f, 2.7f, 10.43f, 2.97f)
                curveTo(8.07f, 4.95f, 3.88f, 9.12f, 3.9f, 13.9f)
                curveTo(3.9f, 17.92f, 6.84f, 21.25f, 10.68f, 21.89f)
                curveTo(10.98f, 21.94f, 11.25f, 21.69f, 11.25f, 21.39f)
                verticalLineTo(3.36f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(13.44f, 12.47f)
                lineTo(18.73f, 10.25f)
                curveTo(19f, 10.13f, 19.13f, 9.82f, 19f, 9.56f)
                curveTo(18.63f, 8.83f, 18.2f, 8.12f, 17.73f, 7.46f)
                curveTo(17.59f, 7.26f, 17.33f, 7.2f, 17.11f, 7.3f)
                lineTo(13.02f, 9.29f)
                curveTo(12.85f, 9.37f, 12.74f, 9.55f, 12.74f, 9.74f)
                verticalLineTo(12.01f)
                curveTo(12.75f, 12.36f, 13.11f, 12.61f, 13.44f, 12.47f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(19.83f, 14.31f)
                curveTo(19.99f, 14.23f, 20.09f, 14.08f, 20.09f, 13.91f)
                curveTo(20.09f, 13.27f, 20.01f, 12.64f, 19.87f, 12.02f)
                curveTo(19.8f, 11.72f, 19.47f, 11.56f, 19.19f, 11.68f)
                lineTo(13.05f, 14.3f)
                curveTo(12.87f, 14.38f, 12.75f, 14.56f, 12.75f, 14.76f)
                verticalLineTo(16.96f)
                curveTo(12.75f, 17.33f, 13.14f, 17.57f, 13.47f, 17.41f)
                lineTo(19.37f, 14.54f)
                lineTo(19.83f, 14.31f)
                close()
            }
        }.build()

        return _Blur!!
    }

@Suppress("ObjectPropertyName")
private var _Blur: ImageVector? = null
