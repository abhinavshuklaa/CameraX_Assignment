package com.example.cameraxalbums

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cameraxalbums.database.AlbumDao
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.database.AlbumsDatabaseClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DataBaseTest {
    private lateinit var database: AlbumsDatabaseClient
    private lateinit var dao: AlbumDao

    @Before
    fun initDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            AlbumsDatabaseClient::class.java
        ).build()
        dao = database.albumDao()

    }

    @Test
    fun insertData() {
        val taskEntity = Albums(2, "sample album", 7777)
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAlbumDetails(taskEntity)

            val tasks = dao.fetchAlbumDetails()
            tasks.value?.let {
                assert(it.isNotEmpty())
            }
        }
    }

}