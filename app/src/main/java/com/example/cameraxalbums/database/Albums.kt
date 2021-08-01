package com.example.cameraxalbums.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This class represents a table within the database.
 */
@Entity(tableName = "albums")
class Albums(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "album_id")
    var album_id: Int = 1,
    @ColumnInfo(name = "album_name")
    val album_name: String,
    @ColumnInfo(name = "time_stamp")
    val time_stamp: Long
)