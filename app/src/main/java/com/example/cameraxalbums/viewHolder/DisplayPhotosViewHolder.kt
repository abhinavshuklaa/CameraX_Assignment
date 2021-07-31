package com.example.cameraxalbums.viewHolder

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraxalbums.listener.PhotoItemClickListener
import kotlinx.android.synthetic.main.item_image.view.*

class DisplayPhotosViewHolder(
    var view: View,
    private val photoItemClickListener: PhotoItemClickListener
) : RecyclerView.ViewHolder(view) {
    fun setImageData(p: String) {
        view.apply {
            val bitmap = BitmapFactory.decodeFile(p)
            img_path.setImageBitmap(bitmap)
            img_path.setOnClickListener(View.OnClickListener {
                photoItemClickListener.onPhotoClicked(adapterPosition, p)
            })


        }
    }
}