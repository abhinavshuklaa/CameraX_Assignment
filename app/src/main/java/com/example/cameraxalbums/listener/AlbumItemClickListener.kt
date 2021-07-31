package com.example.cameraxalbums.listener

import com.example.cameraxalbums.database.Albums

interface AlbumItemClickListener {
    fun onItemClicked(albums: Albums)
}