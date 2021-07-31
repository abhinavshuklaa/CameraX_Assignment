package com.example.cameraxalbums.view.activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cameraxalbums.R
import kotlinx.android.synthetic.main.activity_preview_image.*

class PreviewImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_image)

        val previewImage = getImageDataFromIntent()
        val myBitmap = BitmapFactory.decodeFile(previewImage)
        setImageBitmap(myBitmap)
    }

    private fun setImageBitmap(myBitmap: Bitmap?) {
        img_path_1.setImageBitmap(myBitmap)
    }

    private fun getImageDataFromIntent(): String? {
        return intent.getStringExtra("display_image")
    }
}