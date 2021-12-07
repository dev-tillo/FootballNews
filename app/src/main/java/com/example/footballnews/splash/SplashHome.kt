package com.example.footballnews.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.footballnews.R
import com.example.footballnews.adapters.ViewPagerAdapterHome
import com.example.footballnews.databinding.FragmentSplashHomeBinding

class SplashHome : Fragment() {

    private lateinit var fragment: FragmentSplashHomeBinding
    private lateinit var viewPagerAdapterHome: ViewPagerAdapterHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragment = FragmentSplashHomeBinding.inflate(inflater, container, false)

        viewPagerAdapterHome = ViewPagerAdapterHome(this)
        fragment.viewpager.adapter = viewPagerAdapterHome
        fragment.viewpager.isUserInputEnabled = false

        fragment.bottomnavigation.setOnItemSelectedListener {
            when (it) {
                0 -> fragment.viewpager.currentItem = 0
                1 -> fragment.viewpager.currentItem = 1
                else -> fragment.viewpager.currentItem = 2
            }
        }
        fragment.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        fragment.bottomnavigation.itemActiveIndex = 0
                    }
                    1 -> {
                        fragment.bottomnavigation.itemActiveIndex = 1
                    }
                    else -> fragment.bottomnavigation.itemActiveIndex = 2
                }
                fragment.bottomnavigation.itemActiveIndex = position
            }
        })

        return fragment.root
    }
}