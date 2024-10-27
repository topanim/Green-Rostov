package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIIcons

val SHUIIcons.Loader2: ImageVector
    get() {
        if (_Loader2 != null) {
            return _Loader2!!
        }
        _Loader2 = ImageVector.Builder(
            name = "Loader2",
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
                moveTo(21f, 12f)
                curveTo(21f, 13.901f, 20.398f, 15.752f, 19.281f, 17.29f)
                curveTo(18.164f, 18.827f, 16.588f, 19.972f, 14.781f, 20.559f)
                curveTo(12.973f, 21.146f, 11.026f, 21.146f, 9.219f, 20.559f)
                curveTo(7.411f, 19.972f, 5.836f, 18.827f, 4.719f, 17.289f)
                curveTo(3.602f, 15.752f, 3f, 13.9f, 3f, 11.999f)
                curveTo(3f, 10.099f, 3.602f, 8.247f, 4.719f, 6.709f)
                curveTo(5.836f, 5.172f, 7.411f, 4.027f, 9.219f, 3.44f)
                curveTo(11.026f, 2.853f, 12.973f, 2.853f, 14.781f, 3.44f)
            }
        }.build()

        return _Loader2!!
    }

@Suppress("ObjectPropertyName")
private var _Loader2: ImageVector? = null
