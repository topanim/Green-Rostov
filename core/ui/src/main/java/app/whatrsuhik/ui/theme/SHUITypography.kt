package app.whatrsuhik.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val LocalSHUITypography = staticCompositionLocalOf { SHUITypography.Common }

data class SHUITypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val p: TextStyle,
    val pUi: TextStyle,
    val pUiMedium: TextStyle,
    val blockquote: TextStyle,
    val list: TextStyle,
    val body: TextStyle,
    val bodyMedium: TextStyle,
    val inlineCode: TextStyle,
    val lead: TextStyle,
    val large: TextStyle,
    val small: TextStyle,
    val subtle: TextStyle,
    val subtleMedium: TextStyle,
    val subleSemibold: TextStyle,
    val detail: TextStyle,
    val tableHeader: TextStyle,
    val tableItem: TextStyle,
    val extraSmall: TextStyle,
    val extraSmallBold: TextStyle,
) {
    companion object Defaults {
        val Common = SHUITypography(
            h1 = TextStyle(
                fontSize = 48.sp,
                lineHeight = 48.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            h2 = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                fontWeight = FontWeight.SemiBold
            ),
            h3 = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.SemiBold
            ),
            h4 = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold
            ),
            p = TextStyle(
                fontSize = 16.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Normal
            ),
            pUi = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            ),
            pUiMedium = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium
            ),
            blockquote = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontStyle = FontStyle.Italic
            ),
            list = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            body = TextStyle(
                fontSize = 14.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            ),
            bodyMedium = TextStyle(
                fontSize = 14.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium
            ),
            inlineCode = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            ),
            lead = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Normal
            ),
            large = TextStyle(
                fontSize = 18.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.SemiBold
            ),
            small = TextStyle(
                fontSize = 14.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.Medium
            ),
            subtle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            subtleMedium = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            subleSemibold = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold
            ),
            detail = TextStyle(
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.Medium
            ),
            tableHeader = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            tableItem = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            extraSmall = TextStyle(
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(500)
            ),
            extraSmallBold = TextStyle(
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(700)
            )
        )
    }
}