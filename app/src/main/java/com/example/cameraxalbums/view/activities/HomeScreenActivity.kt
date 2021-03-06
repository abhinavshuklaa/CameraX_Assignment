package com.example.cameraxalbums.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cameraxalbums.R
import com.example.cameraxalbums.view.adapters.AlbumsListAdapter
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.view.listener.AlbumItemClickListener
import com.example.cameraxalbums.viewModel.AlbumLogicViewModel
import com.example.cameraxalbums.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_home_screen.*

/**
 *  This Activity displays the List of student stored in the database,
 *  Here the user can see all the list of albums he/she has created in the form of beautiful grids.
 */
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
        val gridLayoutManager = StaggeredGridLayoutManager(2, 1)
        val albumsListAdapter = AlbumsListAdapter(it, this)
        recyclerViewShowAlbums.apply {
            layoutManager = gridLayoutManager
            adapter = albumsListAdapter

        }

    }

    override fun onItemClicked(albums: Albums) {
        val albumName = albums.album_name
        val intent = Intent(this, ShowCapturedImageActivity::class.java)
        intent.putExtra("data", albumName)
        startActivity(intent)
    }
}