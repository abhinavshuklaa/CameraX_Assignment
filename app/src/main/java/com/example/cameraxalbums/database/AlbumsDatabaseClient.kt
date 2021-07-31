package com.example.cameraxalbums.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Albums::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AlbumsDatabaseClient : RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var INSTANCE: AlbumsDatabaseClient? = null

        fun getDatabase(context: Context): AlbumsDatabaseClient =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AlbumsDatabaseClient::class.java, "album_details_database"
            ).build()
    }
}

