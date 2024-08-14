package com.r42914lg.ndk_1

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NdkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InputScreen()
                }
            }
        }
    }

//    private fun initUi() = with(binding) {
//        bBarcode.setOnClickListener {
//            val textOfInterest = ("*" + etBarcode.text.toString().uppercase(Locale.ROOT)) + "*"
//            val width = resources.displayMetrics.widthPixels
//            val bitmapWip = Bitmap.createBitmap(width - 20, 100, Bitmap.Config.ALPHA_8)
//            drawBarcode(textOfInterest, bitmapWip)
//            ivBarcode.setImageBitmap(bitmapWip)
//        }
//    }

    private external fun drawBarcode(text: String, bitmap: Bitmap?)

    companion object {
        init {
            System.loadLibrary("ndk_1")
        }
    }
}