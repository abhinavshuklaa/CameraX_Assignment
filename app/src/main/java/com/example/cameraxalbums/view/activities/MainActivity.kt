package com.example.cameraxalbums.view.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cameraxalbums.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var camera: Camera? = null
    private var preview: Preview? = null
    private var imageCapture: ImageCapture? = null
    private var lensFacing: Int = CameraSelector.LENS_FACING_BACK

    private val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermissionInOnCreate()
        handlingButtonClicks()

    }

    /**
     * This method is for handling the button Clicks for Camera Operation
     */
    private fun handlingButtonClicks() {
        btn_capture.setOnClickListener {
            captureImage()
            btn_capture.snack("Image Captured")
        }
        camera_switch_button.setOnClickListener {
            switchCamera()
        }

        btn_show_images.setOnClickListener {
            val intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * function checking & requesting where the Camera and storage permission is granted
     */
    private fun checkPermissionInOnCreate() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 0)
        }
    }

    /**
     * Switching the camera (front & rear)
     */
    private fun switchCamera() {

        lensFacing = if (CameraSelector.LENS_FACING_FRONT == lensFacing) {
            CameraSelector.LENS_FACING_BACK
        } else {
            CameraSelector.LENS_FACING_FRONT

        }
        captureImage()


    }

    /***
     *This function is used for getting the directory name (album name) via intent
     * Over here it will pass the media directory from external
     * storage of the device
     */
    private fun getOutputDirectory(): File {
        val directoryName = intent.getStringExtra("directoryName")
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, directoryName!!).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }

    /***
     * This function is saving the images with the help of Current TimeStamp
     */
    private fun captureImage() {
        val mediaDir = File(
            getOutputDirectory(), SimpleDateFormat(
                FILENAME_FORMAT, Locale.US
            ).format(System.currentTimeMillis()) + ".jpg"
        )

        /***
         * This function is defining where we will save our output file
         */
        val resultImage = ImageCapture.OutputFileOptions.Builder(mediaDir).build()
        imageCapture?.takePicture(
            resultImage,
            ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {

                }

                override fun onError(exception: ImageCaptureException) {
                    Toast.makeText(this@MainActivity, "Image is Not Saved", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }

    /***
     * This function is for taking permission from the user to open the Camera
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            startCamera()
        } else {
            Toast.makeText(this, "Accept the Permission For camera", Toast.LENGTH_SHORT).show()
        }
    }

    /***
     * This function is used for binding the camera with the app lifecycle and previewing the camera
     */
    private fun startCamera() {
        /***
         * This method here will check if the camera has been attached with the application lifecycle.
         */
        val cameraProvider = ProcessCameraProvider.getInstance(this)
        cameraProvider.addListener({
            val cameraProvider1 = cameraProvider.get()
            preview = Preview.Builder().build()
            preview?.setSurfaceProvider(camera_view.surfaceProvider)

            imageCapture = ImageCapture.Builder().build()
            val cameraSelector =
                CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build()
            cameraProvider1.unbindAll()
            camera =
                cameraProvider1.bindToLifecycle(this, cameraSelector, preview, imageCapture)
        }, ContextCompat.getMainExecutor(this))
    }

    fun View.snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
        Snackbar.make(this, message, duration).show()
    }
}
