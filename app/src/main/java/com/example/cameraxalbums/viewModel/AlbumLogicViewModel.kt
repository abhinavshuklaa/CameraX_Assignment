package com.example.cameraxalbums.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cameraxalbums.database.Albums
import com.masai_technology.cameraapp.repository.ListRepository

/***
 * This will list all the albums_name and insert into the database
 */
class AlbumLogicViewModel(private val context: Context) : ViewModel() {
    private val repository = ListRepository(context)

    /**
     * This method is used to insert the data to the database
     */
    fun insertAlbumsDetails(id: Int, name: String) {
        repository.insertAlbumsDetails(id, name, context)
    }

    /**
     * This will fetch the list of album_name from database and notify the activity with the help of
     * live data
     */
    fun fetchAllAlbums(): LiveData<List<Albums>> {
        return repository.fetchAlbumsDetails()
    }

}
