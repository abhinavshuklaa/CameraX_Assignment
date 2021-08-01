package com.example.cameraxalbums.view.viewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cameraxalbums.R
import kotlinx.android.synthetic.main.activity_view_pager_indroductory.*

/**
 * This Activity demonstrates a simple view pager where there are 2 Fragments.
 */
class ViewPagerIntroductoryActivity : AppCompatActivity() {
    private lateinit var fragmentAdapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_indroductory)
        setViewPagerAdapter()
        initializingAndSettingViewPager()
    }

    private fun initializingAndSettingViewPager() {
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)


    }

    /**
     *This method sets data to the View Pager Adapter class
     */
    private fun setViewPagerAdapter() {
        fragmentAdapter = FragmentAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

        )

    }
}