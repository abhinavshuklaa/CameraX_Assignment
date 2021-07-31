package com.example.cameraxalbums.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumDao {

    @Insert
    fun insertAlbumDetails(albums: Albums)

    @Query("Select * from albums")
    fun fetchAlbumDetails(): LiveData<List<Albums>>

}