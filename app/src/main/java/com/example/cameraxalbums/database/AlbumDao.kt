package com.example.cameraxalbums.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Data access object. A mapping of SQL queries to functions.
 * When we use a DAO, we call the methods, and Room takes care of the rest.
 */
@Dao
interface AlbumDao {

    @Insert
    fun insertAlbumDetails(albums: Albums)

    @Query("Select * from albums")
    fun fetchAlbumDetails(): LiveData<List<Albums>>

}