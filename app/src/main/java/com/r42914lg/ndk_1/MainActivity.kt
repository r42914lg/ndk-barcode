package com.r42914lg.ndk_1

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.r42914lg.ndk_1.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() = with(binding) {
        bBarcode.setOnClickListener {
            val textOfInterest = ("*" + etBarcode.text.toString().uppercase(Locale.ROOT)) + "*"
            val width = resources.displayMetrics.widthPixels
            val bitmapWip = Bitmap.createBitmap(width - 20, 100, Bitmap.Config.ALPHA_8)
            drawBarcode(textOfInterest, bitmapWip)
            ivBarcode.setImageBitmap(bitmapWip)
        }
    }

    private external fun drawBarcode(text: String, bitmap: Bitmap?)

    companion object {
        init {
            System.loadLibrary("ndk_1")
        }
    }
}