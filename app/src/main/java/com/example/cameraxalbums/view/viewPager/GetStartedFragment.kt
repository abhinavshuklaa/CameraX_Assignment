package com.example.cameraxalbums.view.viewPager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cameraxalbums.view.activities.MainActivity
import com.example.cameraxalbums.R
import com.example.cameraxalbums.database.Directory
import com.example.cameraxalbums.viewModel.AlbumLogicViewModel
import com.example.cameraxalbums.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_get_started.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GetStartedFragment : Fragment() {
    private lateinit var albumLogicViewModel: AlbumLogicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_started, container, false)

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GetStartedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumLogicViewModel =
            ViewModelFactory(this.requireContext()).create(AlbumLogicViewModel::class.java)


        val name = etEnterAlbumName.text.toString()
        var id = 0
        iBtnCreateAlbum.setOnClickListener {

            val directory = Directory(id, name)
            albumLogicViewModel.insertAlbumsDetails(id, etEnterAlbumName.text.toString())
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("directoryName", etEnterAlbumName.text.toString())
            startActivity(intent)
        }

    }
}