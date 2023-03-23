package com.example.habits.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.habits.Fragments.BadHabitsFragment
import com.example.habits.Fragments.GoodHabitsFragment
import com.example.habits.Fragments.MainFragment

class AdapterViews(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList = listOf(
        GoodHabitsFragment(),
        MainFragment(),
        BadHabitsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}