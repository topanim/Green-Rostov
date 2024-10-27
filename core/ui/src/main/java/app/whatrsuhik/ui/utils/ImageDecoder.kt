package app.whatrsuhik.ui.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64




fun decodeBase64ToBytes(base64String: String): ByteArray {
    return Base64.decode(base64String, Base64.DEFAULT)
}

// Функция для декодирования строки Base64 в Bitmap
fun decodeBase64ToBitmap(base64String: String): Bitmap? {
    val imageBytes = decodeBase64ToBytes(base64String)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}



