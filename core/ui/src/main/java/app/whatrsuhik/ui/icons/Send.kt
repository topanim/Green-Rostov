package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIIcons

val SHUIIcons.Send: ImageVector
    get() {
        if (_Send != null) {
            return _Send!!
        }
        _Send = ImageVector.Builder(
            name = "Subtract",
            defaultWidth = 18.dp,
            defaultHeight = 18.dp,
            viewportWidth = 18f,
            viewportHeight = 18f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF2A9E66)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.314f, 9.271f)
                lineTo(3.942f, 8.147f)
                curveTo(1.589f, 7.363f, 0.412f, 6.971f, 0.412f, 6.25f)
                curveTo(0.412f, 5.529f, 1.589f, 5.137f, 3.942f, 4.353f)
                lineTo(14.705f, 0.765f)
                curveTo(16.361f, 0.213f, 17.189f, -0.063f, 17.626f, 0.374f)
                curveTo(18.063f, 0.811f, 17.787f, 1.639f, 17.235f, 3.295f)
                lineTo(13.647f, 14.058f)
                curveTo(12.863f, 16.411f, 12.471f, 17.588f, 11.75f, 17.588f)
                curveTo(11.029f, 17.588f, 10.637f, 16.411f, 9.853f, 14.058f)
                lineTo(8.729f, 10.686f)
                lineTo(13.582f, 5.832f)
                curveTo(13.973f, 5.442f, 13.973f, 4.808f, 13.582f, 4.418f)
                curveTo(13.191f, 4.027f, 12.558f, 4.027f, 12.168f, 4.418f)
                lineTo(7.314f, 9.271f)
                close()
            }
        }.build()

        return _Send!!
    }

@Suppress("ObjectPropertyName")
private var _Send: ImageVector? = null
