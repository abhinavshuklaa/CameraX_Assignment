package com.example.cameraxalbums.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraxalbums.R
import com.example.cameraxalbums.database.Albums
import com.example.cameraxalbums.view.listener.AlbumItemClickListener
import com.example.cameraxalbums.view.viewHolder.AlbumViewHolder

/**
 * This adapter is the piece that will connect our data to our RecyclerView and
 * determine the ViewHolder which will need to be used to display that data.
 */
class AlbumsListAdapter(
    private var ModelList: List<Albums>,
    private val albumItemClickListener: AlbumItemClickListener
) :
    RecyclerView.Adapter<AlbumViewHolder>() {
    /**
     * This method is called right when the adapter is created and is used to initialize your ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.show_albums_item_layout, parent, false)
        return AlbumViewHolder(view, albumItemClickListener)
    }

    /**
     * This method is called for each ViewHolder to bind it to the adapter.
     * This is where we will pass our data to our ViewHolder.
     */
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val dataModel = ModelList[position]
        holder.setData(dataModel)
    }

    /**
     * This method returns the size of the collection that contains the items we want to display
     */
    override fun getItemCount(): Int {
        return ModelList.size
    }

    /**
     * In case of any change to our list, we again have to notify the adapter.
     */
    fun updateList(modelList: List<Albums>) {
        ModelList = modelList
        notifyDataSetChanged()
    }

}