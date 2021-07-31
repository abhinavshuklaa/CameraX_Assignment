package com.example.cameraxalbums.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.listener.AlbumItemClickListener
import kotlinx.android.synthetic.main.show_albums_item_layout.view.*

class AlbumViewHolder(
    private val view: View,
    private val itemClickListener: AlbumItemClickListener
) :
    RecyclerView.ViewHolder(view) {
    fun setData(albums: Albums) {
        view.apply {
            tvAlbumName.text = albums.album_name
            cardViewAlbum.setOnClickListener {
                itemClickListener.onItemClicked(albums)
            }
        }

    }


}