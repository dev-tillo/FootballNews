package com.example.footballnews.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.footballnews.bottomfragments.Championats
import com.example.footballnews.bottomfragments.NewsAll
import com.example.footballnews.bottomfragments.User

class ViewPagerAdapterHome(var fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Championats()
            1 -> NewsAll()
            else -> User()
        }
    }
}