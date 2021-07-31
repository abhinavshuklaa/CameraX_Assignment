package com.example.cameraxalbums.viewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cameraxalbums.R
import kotlinx.android.synthetic.main.activity_view_pager_indroductory.*

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

    private fun setViewPagerAdapter() {
        fragmentAdapter = FragmentAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

        )

    }
}