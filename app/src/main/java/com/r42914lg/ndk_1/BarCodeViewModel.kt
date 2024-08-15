package com.r42914lg.ndk_1

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class BarCodeViewModel(
    private val screenWidth: Int,
) : ViewModel() {

    private val barCodeWrapper = BarCodeWrapper()

    private val _bitmap = MutableStateFlow<Bitmap?>(null)
    val bitmap = _bitmap.asStateFlow()

    fun produce(text: String) {
        val textOfInterest = ("*" + text.uppercase(Locale.ROOT)) + "*"
        val bitmapWip = Bitmap.createBitmap( screenWidth - 20, 100, Bitmap.Config.ALPHA_8)
        barCodeWrapper.drawBarcode(textOfInterest, bitmapWip)
        _bitmap.value = bitmapWip
    }
}