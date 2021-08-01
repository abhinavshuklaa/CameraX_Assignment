package com.example.cameraxalbums.view.listener

/**
 * To handle the item clicks of the recycler view as the user wants to see all the pics when a particular item is being clicked.
 * This is done using the interfaces.
 */
interface PhotoItemClickListener {
    fun onPhotoClicked(position: Int, p: String)

}