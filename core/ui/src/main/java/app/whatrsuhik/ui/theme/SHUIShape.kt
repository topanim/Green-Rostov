package app.whatrsuhik.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val LocalSHUIShape =
    compositionLocalOf<SHUIShape> { SHUIShapes.Medium }

typealias SHUIShape = Shape

object SHUIShapes {
    val None = RectangleShape
    val Small = RoundedCornerShape(5.dp)
    val Medium = RoundedCornerShape(12.dp)
    val Large = RoundedCornerShape(18.dp)
    val Circle = CircleShape
}