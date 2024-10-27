package app.whatrsuhik.profile.profile.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.components.styled_box.StyledBox
import app.whatrsuhik.ui.icons.User
import app.whatrsuhik.ui.theme.SHUIIcons
import app.whatrsuhik.ui.theme.SHUIShapes

@Composable
fun UserAvatar(
    modifier: Modifier = Modifier,
    icon: ImageVector = SHUIIcons.User,
) = StyledBox(
    modifier = modifier,
    shape = SHUIShapes.Circle
) {
    Icon(
        imageVector = icon,
        contentDescription = "user avatar",
        Modifier.size(54.dp)
    )
}