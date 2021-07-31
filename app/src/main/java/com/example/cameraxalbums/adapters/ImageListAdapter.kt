package com.example.cameraxalbums.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraxalbums.R
import com.example.cameraxalbums.listener.PhotoItemClickListener
import com.example.cameraxalbums.viewHolder.DisplayPhotosViewHolder

class ImageListAdapter(
    private val list: List<String>,
    private val photoItemClickListener: PhotoItemClickListener
) :
    RecyclerView.Adapter<DisplayPhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayPhotosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return DisplayPhotosViewHolder(view, photoItemClickListener)
    }

    override fun onBindViewHolder(holder: DisplayPhotosViewHolder, position: Int) {
        val model = list[position]
        holder.setImageData(model)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}