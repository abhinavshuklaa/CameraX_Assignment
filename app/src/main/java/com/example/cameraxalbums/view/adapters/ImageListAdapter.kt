package com.example.cameraxalbums.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraxalbums.R
import com.example.cameraxalbums.view.listener.PhotoItemClickListener
import com.example.cameraxalbums.view.viewHolder.DisplayPhotosViewHolder

/**
 * This adapter is the piece that will connect our data to our RecyclerView and
 * determine the ViewHolder which will need to be used to display that data.
 */
class ImageListAdapter(
    private val list: List<String>,
    private val photoItemClickListener: PhotoItemClickListener
) :
    RecyclerView.Adapter<DisplayPhotosViewHolder>() {
    /**
     * This method is called right when the adapter is created and is used to initialize your ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayPhotosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
        return DisplayPhotosViewHolder(view, photoItemClickListener)
    }

    /**
     * This method is called for each ViewHolder to bind it to the adapter.
     * This is where we will pass our data to our ViewHolder.
     */
    override fun onBindViewHolder(holder: DisplayPhotosViewHolder, position: Int) {
        val model = list[position]
        holder.setImageData(model)
    }

    /**
     * This method returns the size of the collection that contains the items we want to display
     */
    override fun getItemCount(): Int {
        return list.size
    }
}