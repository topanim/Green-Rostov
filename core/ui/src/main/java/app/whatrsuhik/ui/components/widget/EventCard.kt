package app.whatrsuhik.ui.components.widget

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.R
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.icons.CalendarTick
import app.whatrsuhik.ui.theme.SHUIShapes
import app.whatrsuhik.ui.theme.SHUITheme.palettes
import app.whatrsuhik.ui.theme.SHUITheme.spacing
import app.whatrsuhik.ui.theme.SHUITheme.typography
import app.whatrsuhik.ui.utils.GeocoderUtil
import app.whatrsuhik.ui.utils.decodeBase64ToBitmap
import kotlinx.coroutines.launch


@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    id: Int,
    name: String,
    description: String,
    picture: String,
    lati: Double,
    long: Double,
    onLongPress: () -> Unit = {},
    onClick: () -> Unit
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .clip(SHUIShapes.Medium)
        .border(1.dp, palettes.border, SHUIShapes.Medium)
        .background(palettes.secondary)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = { onClick() },
                onLongPress = { onLongPress() }
            )
        }
) {

    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(picture) {
        bitmap = decodeBase64ToBitmap(picture)
    }


    LaunchedEffect(Unit) {
        text = GeocoderUtil.getAddressFromCoordinates(context, lati.toString(), long.toString())

    }

    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        bitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "",
                Modifier.size(135.dp, 76.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Space(spacing.sm + spacing.xs)

        Column {
            TitleBlock(name)

            Space(spacing.sm)

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
            DescriptionBlock(text)
        }
    }

                RatingBox(
                    4.7f,
                    Modifier.padding(spacing.sm.dp)
                )
            }
        }


@Composable
fun TitleBlock(name: String) = Text(
    text = name,
    style = typography.pUiMedium,
    color = palettes.foreground,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)


@Composable
fun DescriptionBlock(address: String)= Column {
    Row {
        Icon(
            imageVector = CalendarTick, "",
            Modifier.size(12.dp),
            tint = palettes.secondaryForeground
        )

        Space(spacing.xs)

        Text(
            "30 октября,12:00",
            style = typography.extraSmall,
            color = palettes.secondaryForeground
        )
    }

    VerticalSpace(5)

    Row {
        Icon(
            Icons.Default.Place, "",
            Modifier.size(12.dp),
            tint = palettes.mutedForeground
        )
        Space(5)
        Text(
            address,
            style = typography.extraSmall,
            color = palettes.mutedForeground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
    }
}

@Composable
fun RatingBox(rating: Float, modifier: Modifier) = Box(
    modifier = modifier
        .size(30.dp, 23.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(palettes.foreground),
    contentAlignment = Alignment.Center
) {
    Text(
        "$rating",
        style = typography.extraSmallBold,
        color = palettes.background
    )
}