package com.example.cameraxalbums

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cameraxalbums.adapters.AlbumsListAdapter
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.listener.AlbumItemClickListener
import com.example.cameraxalbums.viewModel.AlbumLogicViewModel
import com.example.cameraxalbums.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : AppCompatActivity(), AlbumItemClickListener {
    private lateinit var viewModel: AlbumLogicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        initialisingTheViewModel()
    }

    private fun initialisingTheViewModel() {
        viewModel = ViewModelFactory(this).create(AlbumLogicViewModel::class.java)
        viewModel.fetchAllAlbums().observe(this, {
            it?.let {
                setRecyclerAdapter(it)
            }
        })
    }

    private fun setRecyclerAdapter(it: List<Albums>) {
        val gridLayoutManager = GridLayoutManager(this, 3)
        val albumsListAdapter = AlbumsListAdapter(it, this)
        recyclerViewShowAlbums.apply {
            layoutManager = gridLayoutManager
            adapter = albumsListAdapter

        }

    }

    override fun onItemClicked(albums: Albums) {
        val albumName = albums.album_name
        val intent = Intent(this, ShowImageActivity::class.java)
        intent.putExtra("data", albumName)
        startActivity(intent)
    }
}