package com.masai_technology.cameraapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.database.AlbumsDatabaseClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/***
 * A class that you create that is primarily used to manage multiple data sources.
 * This is a `M` layer in the `MVVM` architecture,
 * where we are doing the insertion and retrieval operation
 */

class ListRepository(private val context: Context) {
    fun fetchAlbumsDetails(): LiveData<List<Albums>> {

        return AlbumsDatabaseClient.getDatabase(context).albumDao().fetchAlbumDetails()
    }

    /**
     *  * This function uses coroutines to run multiple tasks in parallel

     */
    fun insertAlbumsDetails(id: Int, name: String, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {

            val album = Albums(id, album_name = name, time_stamp = System.currentTimeMillis())
            AlbumsDatabaseClient.getDatabase(context).albumDao().insertAlbumDetails(album)
        }
    }
}