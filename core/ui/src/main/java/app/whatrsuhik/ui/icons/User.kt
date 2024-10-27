package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIIcons

val SHUIIcons.User: ImageVector
    get() {
        if (_User != null) {
            return _User!!
        }
        _User = ImageVector.Builder(
            name = "User",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(19f, 21f)
                verticalLineTo(19f)
                curveTo(19f, 17.939f, 18.579f, 16.922f, 17.828f, 16.172f)
                curveTo(17.078f, 15.421f, 16.061f, 15f, 15f, 15f)
                horizontalLineTo(9f)
                curveTo(7.939f, 15f, 6.922f, 15.421f, 6.172f, 16.172f)
                curveTo(5.421f, 16.922f, 5f, 17.939f, 5f, 19f)
                verticalLineTo(21f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 11f)
                curveTo(14.209f, 11f, 16f, 9.209f, 16f, 7f)
                curveTo(16f, 4.791f, 14.209f, 3f, 12f, 3f)
                curveTo(9.791f, 3f, 8f, 4.791f, 8f, 7f)
                curveTo(8f, 9.209f, 9.791f, 11f, 12f, 11f)
                close()
            }
        }.build()

        return _User!!
    }

@Suppress("ObjectPropertyName")
private var _User: ImageVector? = null