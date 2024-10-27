package app.whatrsuhik.ui.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import app.whatrsuhik.ui.R
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

object MapDefaults {
    val RostovOnDon = Point(47.2357, 39.7015)
}

@Composable
fun YandexMapKit(
    modifier: Modifier = Modifier,
    darkMode: Boolean = false,
    points: List<Point> = listOf(),
    onResetFocus: () -> Unit = {},
    onTap: (MapObject, Point) -> Boolean = { _, _ -> false }
) {
    val context = LocalContext.current
    val placeMarkTapListener = MapObjectTapListener { mapObject, point ->
        onTap(mapObject, point)
    }

    AndroidView(
        modifier = modifier,
        factory = {
            MapView(it).apply {
                mapWindow.map.isNightModeEnabled = darkMode
                mapWindow.map.move(
                    CameraPosition(
                        Point(47.2357, 39.7015),
                        12f,
                        150.0f,
                        30.0f
                    )
                )
            }
        }
    ) { mapView ->
        mapView.mapWindow.map.mapObjects.clear()
        points.forEach {
            mapView.mapWindow.map.mapObjects
                .addPlacemark()
                .apply {
                    geometry = it
                    setIcon(ImageProvider.fromResource(context, R.drawable.location))
                    addTapListener(placeMarkTapListener)
                }
        }
    }
}

@Composable
fun YandexSelectPositionMap(
    modifier: Modifier = Modifier,
    darkMode: Boolean = false,
    point: Point = MapDefaults.RostovOnDon,
    setPoint: (Point) -> Unit = {}
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            MapView(context).apply {
                mapWindow.map.isNightModeEnabled = darkMode

                mapWindow.map.move(
                    CameraPosition(
                        point,
                        12f,
                        150.0f,
                        30.0f
                    )
                )
            }
        },
        update = {
        }
    )
}

