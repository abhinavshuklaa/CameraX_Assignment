package com.example.cameraxalbums

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cameraxalbums.adapters.ImageListAdapter
import com.example.cameraxalbums.listener.PhotoItemClickListener
import kotlinx.android.synthetic.main.activity_show_image.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class ShowCapturedImageActivity : AppCompatActivity(), PhotoItemClickListener {
    private lateinit var listFile: Array<File>
    private var listToFile = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)
        /***
         * In this we are getting message/data of the directory name via intent
         */
        val name = intent.getStringExtra("data")
        if (name != null) {
            getFromSdcard(name)
        }

    }

    /***
     * In this method we are trying to get the Image(file path) which is saved in the external Storage of the mobile device
     */
    private fun getFromSdcard(root: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val file = externalMediaDirs.firstOrNull()?.let { File(it, root) }
            if (file?.isDirectory!!) {
                listFile = file.listFiles()!!
                for (element in listFile) {
                    listToFile.add(element.absolutePath)
                }
            }
        }.invokeOnCompletion {
            setAdapter()
        }
    }

    /***
     * OverHere we are setting up the recyclerAdapter
     */
    private fun setAdapter() {
        CoroutineScope(Dispatchers.Main).launch {
            val gridLayoutManager = GridLayoutManager(this@ShowCapturedImageActivity, 2)
            val adapter = ImageListAdapter(listToFile, this@ShowCapturedImageActivity)
            recyclerViewShowImages.adapter = adapter
            recyclerViewShowImages.layoutManager = gridLayoutManager
        }
    }

    /**
     *Handling the clicks for each album in a recyclerView
     */
    override fun onPhotoClicked(position: Int, p: String) {
        val intent = Intent(this, PreviewImageActivity::class.java)
        intent.putExtra("display_image", p)
        startActivity(intent)

    }
}