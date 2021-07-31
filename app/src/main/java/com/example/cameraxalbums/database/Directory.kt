package com.example.cameraxalbums.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Directory")
class Directory( @PrimaryKey
                 @ColumnInfo(name = "album_id")
                 val album_id: Int=0,

                 @ColumnInfo(name = "album_name")
                 val album_name: String)
