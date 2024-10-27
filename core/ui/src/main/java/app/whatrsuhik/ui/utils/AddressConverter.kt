package app.whatrsuhik.ui.utils

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale

object GeocoderUtil {
    suspend fun getAddressFromCoordinates(context: Context, latitude: String, longitude: String): String {
        return withContext(Dispatchers.IO) {
            try {
                val lat = latitude.toDouble()
                val lon = longitude.toDouble()
                val geocoder = Geocoder(context, Locale.getDefault())

                // Проверка доступности Geocoder
                if (!Geocoder.isPresent()) {
                    return@withContext "Geocoder is not available."
                }

                val addresses: MutableList<Address> = geocoder.getFromLocation(lat, lon, 1)!!

                if (addresses.isNotEmpty()) {
                    addresses[0].getAddressLine(0) ?: "Address not found"
                } else {
                    "Address not found"
                }
            } catch (e: Exception) {
                Log.e("GeocodingError", "Error: ${e.message}")
                "Error retrieving address: ${e.message}"
            }
        }
    }
}