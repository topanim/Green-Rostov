package app.whatrsuhik.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalSHUIColor = compositionLocalOf { SHUIColor.Common }

data class SHUIColor(
    val i50: Color,
    val i100: Color,
    val i200: Color,
    val i300: Color,
    val i400: Color,
    val i500: Color,
    val i600: Color,
    val i700: Color,
    val i800: Color,
    val i900: Color,
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF)
) {
    companion object Defaults {
        val slate = SHUIColor(
            i50 = Color(0xFFF8FAFC),
            i100 = Color(0xFFF1F5F9),
            i200 = Color(0xFFE2E8F0),
            i300 = Color(0xFFCBD5E1),
            i400 = Color(0xFF94A3B8),
            i500 = Color(0xFF64748B),
            i600 = Color(0xFF475569),
            i700 = Color(0xFF334155),
            i800 = Color(0xFF1E293B),
            i900 = Color(0xFF0F172A)
        )

        val gray = SHUIColor(
            i50 = Color(0xFFF9FAFB),
            i100 = Color(0xFFF3F4F6),
            i200 = Color(0xFFE5E7EB),
            i300 = Color(0xFFD1D5DB),
            i400 = Color(0xFF9CA3AF),
            i500 = Color(0xFF6B7280),
            i600 = Color(0xFF4B5563),
            i700 = Color(0xFF374151),
            i800 = Color(0xFF1F2937),
            i900 = Color(0xFF111827)
        )

        val zinc = SHUIColor(
            i50 = Color(0xFFFAFAFA),
            i100 = Color(0xFFF4F4F5),
            i200 = Color(0xFFE4E4E7),
            i300 = Color(0xFFD4D4D8),
            i400 = Color(0xFFA1A1AA),
            i500 = Color(0xFF71717A),
            i600 = Color(0xFF52525B),
            i700 = Color(0xFF3F3F46),
            i800 = Color(0xFF27272A),
            i900 = Color(0xFF18181B)
        )

        val neutral = SHUIColor(
            i50 = Color(0xFFFAFAFA),
            i100 = Color(0xFFF5F5F5),
            i200 = Color(0xFFE5E5E5),
            i300 = Color(0xFFD4D4D4),
            i400 = Color(0xFFA3A3A3),
            i500 = Color(0xFF737373),
            i600 = Color(0xFF525252),
            i700 = Color(0xFF404040),
            i800 = Color(0xFF262626),
            i900 = Color(0xFF171717)
        )

        val stone = SHUIColor(
            i50 = Color(0xFFFAFAF9),
            i100 = Color(0xFFF5F5F4),
            i200 = Color(0xFFE7E5E4),
            i300 = Color(0xFFD6D3D1),
            i400 = Color(0xFFA8A29E),
            i500 = Color(0xFF78716C),
            i600 = Color(0xFF57534E),
            i700 = Color(0xFF44403C),
            i800 = Color(0xFF292524),
            i900 = Color(0xFF1C1917)
        )

        val red = SHUIColor(
            i50 = Color(0xFFFEF2F2),
            i100 = Color(0xFFFEE2E2),
            i200 = Color(0xFFFECACA),
            i300 = Color(0xFFFCA5A5),
            i400 = Color(0xFFF87171),
            i500 = Color(0xFFEF4444),
            i600 = Color(0xFFDC2626),
            i700 = Color(0xFFB91C1C),
            i800 = Color(0xFF991B1B),
            i900 = Color(0xFF7F1D1D)
        )

        val orange = SHUIColor(
            i50 = Color(0xFFFFF7ED),
            i100 = Color(0xFFFFEDD5),
            i200 = Color(0xFFFED7AA),
            i300 = Color(0xFFFDBA74),
            i400 = Color(0xFFFB923C),
            i500 = Color(0xFFF97316),
            i600 = Color(0xFFEA580C),
            i700 = Color(0xFFC2410C),
            i800 = Color(0xFF9A3412),
            i900 = Color(0xFF7C2D12)
        )

        val amber = SHUIColor(
            i50 = Color(0xFFFFFBEB),
            i100 = Color(0xFFFEF3C7),
            i200 = Color(0xFFFDE68A),
            i300 = Color(0xFFFCD34D),
            i400 = Color(0xFFFBBF24),
            i500 = Color(0xFFF59E0B),
            i600 = Color(0xFFD97706),
            i700 = Color(0xFFB45309),
            i800 = Color(0xFF92400E),
            i900 = Color(0xFF78350F)
        )

        val yellow = SHUIColor(
            i50 = Color(0xFFFEFCE8),
            i100 = Color(0xFFFEF9C3),
            i200 = Color(0xFFFEF08A),
            i300 = Color(0xFFFDE047),
            i400 = Color(0xFFFACC15),
            i500 = Color(0xFFEAB308),
            i600 = Color(0xFFCA8A04),
            i700 = Color(0xFFA16207),
            i800 = Color(0xFF854D0E),
            i900 = Color(0xFF713F12)
        )

        val lime = SHUIColor(
            i50 = Color(0xFFF7FEE7),
            i100 = Color(0xFFECFCCB),
            i200 = Color(0xFFD9F99D),
            i300 = Color(0xFFBEF264),
            i400 = Color(0xFFA3E635),
            i500 = Color(0xFF84CC16),
            i600 = Color(0xFF65A30D),
            i700 = Color(0xFF4D7C0F),
            i800 = Color(0xFF3F6212),
            i900 = Color(0xFF365314)
        )

        val green = SHUIColor(
            i50 = Color(0xFFF0FDF4),
            i100 = Color(0xFFDCFCE7),
            i200 = Color(0xFFBBF7D0),
            i300 = Color(0xFF86EFAC),
            i400 = Color(0xFF4ADE80),
            i500 = Color(0xFF22C55E),
            i600 = Color(0xFF16A34A),
            i700 = Color(0xFF15803D),
            i800 = Color(0xFF166534),
            i900 = Color(0xFF14532D)
        )

        val emerald = SHUIColor(
            i50 = Color(0xFFECFDF5),
            i100 = Color(0xFFD1FAE5),
            i200 = Color(0xFFA7F3D0),
            i300 = Color(0xFF6EE7B7),
            i400 = Color(0xFF34D399),
            i500 = Color(0xFF10B981),
            i600 = Color(0xFF059669),
            i700 = Color(0xFF047857),
            i800 = Color(0xFF065F46),
            i900 = Color(0xFF064E3B)
        )

        val teal = SHUIColor(
            i50 = Color(0xFFF0FDFA),
            i100 = Color(0xFFCCFBF1),
            i200 = Color(0xFF99F6E4),
            i300 = Color(0xFF5EEAD4),
            i400 = Color(0xFF2DD4BF),
            i500 = Color(0xFF14B8A6),
            i600 = Color(0xFF0D9488),
            i700 = Color(0xFF0F766E),
            i800 = Color(0xFF115E59),
            i900 = Color(0xFF134E4A)
        )

        val cyan = SHUIColor(
            i50 = Color(0xFFECFEFF),
            i100 = Color(0xFFCFFAFE),
            i200 = Color(0xFFA5F3FC),
            i300 = Color(0xFF67E8F9),
            i400 = Color(0xFF22D3EE),
            i500 = Color(0xFF06B6D4),
            i600 = Color(0xFF0891B2),
            i700 = Color(0xFF0E7490),
            i800 = Color(0xFF155E75),
            i900 = Color(0xFF164E63)
        )

        val sky = SHUIColor(
            i50 = Color(0xFFF0F9FF),
            i100 = Color(0xFFE0F2FE),
            i200 = Color(0xFFBAE6FD),
            i300 = Color(0xFF7DD3FC),
            i400 = Color(0xFF38BDF8),
            i500 = Color(0xFF0EA5E9),
            i600 = Color(0xFF0284C7),
            i700 = Color(0xFF0369A1),
            i800 = Color(0xFF075985),
            i900 = Color(0xFF0C4A6E)
        )

        val blue = SHUIColor(
            i50 = Color(0xFFEFF6FF),
            i100 = Color(0xFFDBEAFE),
            i200 = Color(0xFFBFDBFE),
            i300 = Color(0xFF93C5FD),
            i400 = Color(0xFF60A5FA),
            i500 = Color(0xFF3B82F6),
            i600 = Color(0xFF2563EB),
            i700 = Color(0xFF1D4ED8),
            i800 = Color(0xFF1E40AF),
            i900 = Color(0xFF1E3A8A)
        )

        val indigo = SHUIColor(
            i50 = Color(0xFFEEF2FF),
            i100 = Color(0xFFE0E7FF),
            i200 = Color(0xFFC7D2FE),
            i300 = Color(0xFFA5B4FC),
            i400 = Color(0xFF818CF8),
            i500 = Color(0xFF6366F1),
            i600 = Color(0xFF4F46E5),
            i700 = Color(0xFF4338CA),
            i800 = Color(0xFF3730A3),
            i900 = Color(0xFF312E81)
        )

        val violet = SHUIColor(
            i50 = Color(0xFFF5F3FF),
            i100 = Color(0xFFEDE9FE),
            i200 = Color(0xFFDDD6FE),
            i300 = Color(0xFFC4B5FD),
            i400 = Color(0xFFA78BFA),
            i500 = Color(0xFF8B5CF6),
            i600 = Color(0xFF7C3AED),
            i700 = Color(0xFF6D28D9),
            i800 = Color(0xFF5B21B6),
            i900 = Color(0xFF4C1D95)
        )

        val purple = SHUIColor(
            i50 = Color(0xFFFAF5FF),
            i100 = Color(0xFFF3E8FF),
            i200 = Color(0xFFE9D5FF),
            i300 = Color(0xFFD8B4FE),
            i400 = Color(0xFFC084FC),
            i500 = Color(0xFFA855F7),
            i600 = Color(0xFF9333EA),
            i700 = Color(0xFF7E22CE),
            i800 = Color(0xFF6B21A8),
            i900 = Color(0xFF581C87)
        )

        val fuchsia = SHUIColor(
            i50 = Color(0xFFFDF4FF),
            i100 = Color(0xFFFAE8FF),
            i200 = Color(0xFFF5D0FE),
            i300 = Color(0xFFF0ABFC),
            i400 = Color(0xFFE879F9),
            i500 = Color(0xFFD946EF),
            i600 = Color(0xFFC026D3),
            i700 = Color(0xFFA21CAF),
            i800 = Color(0xFF86198F),
            i900 = Color(0xFF701A75)
        )

        val pink = SHUIColor(
            i50 = Color(0xFFFDF2F8),
            i100 = Color(0xFFFCE7F3),
            i200 = Color(0xFFFBCFE8),
            i300 = Color(0xFFF9A8D4),
            i400 = Color(0xFFF472B6),
            i500 = Color(0xFFEC4899),
            i600 = Color(0xFFDB2777),
            i700 = Color(0xFFBE185D),
            i800 = Color(0xFF9D174D),
            i900 = Color(0xFF831843)
        )

        val rose = SHUIColor(
            i50 = Color(0xFFFFF1F2),
            i100 = Color(0xFFFFE4E6),
            i200 = Color(0xFFFECDD3),
            i300 = Color(0xFFFDA4AF),
            i400 = Color(0xFFFB7185),
            i500 = Color(0xFFF43F5E),
            i600 = Color(0xFFE11D48),
            i700 = Color(0xFFBE123C),
            i800 = Color(0xFF9F1239),
            i900 = Color(0xFF881337)
        )

        val Common = slate

        fun all() = listOf(
            slate, gray, zinc, neutral, stone, red, orange, amber, yellow, lime, green,
            emerald, teal, cyan, sky, blue, indigo, violet, purple, fuchsia, pink, rose
        )
    }
}