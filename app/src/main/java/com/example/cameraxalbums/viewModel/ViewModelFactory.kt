package com.example.cameraxalbums.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/***
 * This ViewModelFactory is used when an instance of viewmodel is required
 */
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumLogicViewModel::class.java)) {
            return AlbumLogicViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
