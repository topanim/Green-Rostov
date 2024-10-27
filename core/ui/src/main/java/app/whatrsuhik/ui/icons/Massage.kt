package app.whatrsuhik.ui.icons


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Assistant: ImageVector
    get() {
        if (_Messages != null) {
            return _Messages!!
        }
        _Messages = ImageVector.Builder(
            name = "Messages",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(22f, 12.86f)
                curveTo(22f, 15.15f, 20.82f, 17.18f, 19f, 18.46f)
                lineTo(17.66f, 21.41f)
                curveTo(17.35f, 22.08f, 16.45f, 22.21f, 15.98f, 21.64f)
                lineTo(14.5f, 19.86f)
                curveTo(12.64f, 19.86f, 10.93f, 19.23f, 9.63f, 18.18f)
                lineTo(10.23f, 17.47f)
                curveTo(14.85f, 17.12f, 18.5f, 13.46f, 18.5f, 9f)
                curveTo(18.5f, 8.24f, 18.39f, 7.49f, 18.19f, 6.77f)
                curveTo(20.46f, 7.97f, 22f, 10.25f, 22f, 12.86f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(16.3f, 6.07f)
                curveTo(15.13f, 3.67f, 12.52f, 2f, 9.5f, 2f)
                curveTo(5.36f, 2f, 2f, 5.13f, 2f, 9f)
                curveTo(2f, 11.29f, 3.18f, 13.32f, 5f, 14.6f)
                lineTo(6.34f, 17.55f)
                curveTo(6.65f, 18.22f, 7.55f, 18.34f, 8.02f, 17.78f)
                lineTo(8.57f, 17.12f)
                lineTo(9.5f, 16f)
                curveTo(13.64f, 16f, 17f, 12.87f, 17f, 9f)
                curveTo(17f, 7.95f, 16.75f, 6.96f, 16.3f, 6.07f)
                close()
                moveTo(12f, 9.75f)
                horizontalLineTo(7f)
                curveTo(6.59f, 9.75f, 6.25f, 9.41f, 6.25f, 9f)
                curveTo(6.25f, 8.59f, 6.59f, 8.25f, 7f, 8.25f)
                horizontalLineTo(12f)
                curveTo(12.41f, 8.25f, 12.75f, 8.59f, 12.75f, 9f)
                curveTo(12.75f, 9.41f, 12.41f, 9.75f, 12f, 9.75f)
                close()
            }
        }.build()

        return _Messages!!
    }

@Suppress("ObjectPropertyName")
private var _Messages: ImageVector? = null
