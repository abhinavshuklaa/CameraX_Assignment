package com.example.cameraxalbums.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentAdapter(fm: FragmentManager, behavior: Int) :

    FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return 2

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return SplashScreenFragment.newInstance("This is first Fragment", "FirstFragment")
            }
            1 -> {
                return GetStartedFragment.newInstance("This is second Fragment", "SecondFragment")

            }
        }
        return GetStartedFragment.newInstance("This is second Fragment", "SecondFragment")

    }

//    @Nullable
//    override fun getPageTitle(position: Int): CharSequence? {
//        var tabTitle = ""
//        tabTitle = when (position) {
//            0 -> "FRIENDS"
//            1 -> "GROUPS"
//            2 -> "ACTIVITY"
//            else -> "TAB - n"
//        }
//        return tabTitle
//    }
}