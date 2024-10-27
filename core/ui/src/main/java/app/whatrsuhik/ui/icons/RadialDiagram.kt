package app.whatrsuhik.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.theme.SHUIIcons

val SHUIIcons.RadialDiagram: ImageVector
    get() {
        if (_RadialDiagram != null) {
            return _RadialDiagram!!
        }
        _RadialDiagram = ImageVector.Builder(
            name = "Vector",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFF4AB844))) {
                moveTo(8f, 0.5f)
                curveTo(3.86f, 0.5f, 0.5f, 3.86f, 0.5f, 8f)
                curveTo(0.5f, 12.14f, 3.86f, 15.5f, 8f, 15.5f)
                curveTo(12.14f, 15.5f, 15.5f, 12.14f, 15.5f, 8f)
                curveTo(15.5f, 3.86f, 12.14f, 0.5f, 8f, 0.5f)
                close()
                moveTo(8f, 5.563f)
                curveTo(7.693f, 5.563f, 7.438f, 5.307f, 7.438f, 5f)
                curveTo(7.438f, 4.693f, 7.693f, 4.438f, 8f, 4.438f)
                curveTo(9.965f, 4.438f, 11.563f, 6.035f, 11.563f, 8f)
                curveTo(11.563f, 9.965f, 9.965f, 11.563f, 8f, 11.563f)
                curveTo(7.693f, 11.563f, 7.438f, 11.307f, 7.438f, 11f)
                curveTo(7.438f, 10.693f, 7.693f, 10.438f, 8f, 10.438f)
                curveTo(9.342f, 10.438f, 10.438f, 9.342f, 10.438f, 8f)
                curveTo(10.438f, 6.657f, 9.342f, 5.563f, 8f, 5.563f)
                close()
                moveTo(8f, 13.813f)
                curveTo(4.798f, 13.813f, 2.188f, 11.203f, 2.188f, 8f)
                curveTo(2.188f, 7.693f, 2.443f, 7.438f, 2.75f, 7.438f)
                curveTo(3.057f, 7.438f, 3.313f, 7.693f, 3.313f, 8f)
                curveTo(3.313f, 10.587f, 5.412f, 12.688f, 8f, 12.688f)
                curveTo(10.587f, 12.688f, 12.688f, 10.587f, 12.688f, 8f)
                curveTo(12.688f, 5.412f, 10.587f, 3.313f, 8f, 3.313f)
                curveTo(7.693f, 3.313f, 7.438f, 3.057f, 7.438f, 2.75f)
                curveTo(7.438f, 2.443f, 7.693f, 2.188f, 8f, 2.188f)
                curveTo(11.203f, 2.188f, 13.813f, 4.798f, 13.813f, 8f)
                curveTo(13.813f, 11.203f, 11.203f, 13.813f, 8f, 13.813f)
                close()
            }
        }.build()

        return _RadialDiagram!!
    }

@Suppress("ObjectPropertyName")
private var _RadialDiagram: ImageVector? = null
