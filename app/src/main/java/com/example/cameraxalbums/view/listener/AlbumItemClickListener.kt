package com.example.cameraxalbums.view.listener

import com.example.cameraxalbums.database.Albums

interface AlbumItemClickListener {
    fun onItemClicked(albums: Albums)
}