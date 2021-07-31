package com.example.cameraxalbums.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraxalbums.R
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.view.listener.AlbumItemClickListener
import com.example.cameraxalbums.view.viewHolder.AlbumViewHolder

class AlbumsListAdapter(
    private var ModelList: List<Albums>,
    private val albumItemClickListener: AlbumItemClickListener
) :
    RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.show_albums_item_layout, parent, false)
        return AlbumViewHolder(view, albumItemClickListener)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val dataModel = ModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return ModelList.size
    }

    fun updateList(modelList: List<Albums>) {
        ModelList = modelList
        notifyDataSetChanged()
    }

}