package com.example.footballnews.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.footballnews.R
import com.example.footballnews.adapters.VpforHome
import com.example.footballnews.databinding.BackLayoutBinding
import com.example.footballnews.databinding.FragmentTabAndViewpagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TabAndViewpager : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var fragment: FragmentTabAndViewpagerBinding
    private lateinit var vpforHome: VpforHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragment = FragmentTabAndViewpagerBinding.inflate(inflater, container, false)

        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment.apply {
            tabSet()

            left.setOnClickListener {
                findNavController().popBackStack()
            }

        }
    }

    private fun tabSet() {
        val arr = arrayListOf(
            "Turnament",
            "Goal",
            "Assist",
            "Gaming",
            "Feature"
        )

        vpforHome = VpforHome(this, arr)

        fragment.viewpager2.adapter = vpforHome
//        fragment.viewpager2.isUserInputEnabled = false

        TabLayoutMediator(fragment.tabLayout, fragment.viewpager2) { tab, position ->
            var bind = BackLayoutBinding.inflate(layoutInflater)
            tab.customView = bind.root
            bind.texts.text = arr[position]
            if (position == 0) {
                bind.backs.visibility = View.VISIBLE
                bind.texts.setTextColor(Color.WHITE)
            } else {
                bind.backs.visibility = View.INVISIBLE
                bind.texts.setTextColor(Color.BLACK)
            }
        }.attach()

        fragment.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var bind = BackLayoutBinding.bind(tab?.customView!!)
                bind.backs.visibility = View.VISIBLE
                bind.texts.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var bind = BackLayoutBinding.bind(tab?.customView!!)
                bind.backs.visibility = View.INVISIBLE
                bind.texts.setTextColor(Color.BLACK)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TabAndViewpager().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}