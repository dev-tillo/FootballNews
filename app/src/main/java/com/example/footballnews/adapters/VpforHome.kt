package com.example.footballnews.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.footballnews.fragments.All_rv

class VpforHome(fm: Fragment, var list: List<String>) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return All_rv.newInstance(list[position])
    }
}