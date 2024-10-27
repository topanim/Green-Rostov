package app.whatrsuhik.ui.components.widget

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.R

@Composable
fun DancingMan() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinity rotate transition")

    val angle by infiniteTransition.animateFloat(
        initialValue = -20f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "infinity rotate animation"
    )

    Image(
        painter = painterResource(R.drawable.frame3),
        contentDescription = "ecology",
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .rotate(angle)
    )
}