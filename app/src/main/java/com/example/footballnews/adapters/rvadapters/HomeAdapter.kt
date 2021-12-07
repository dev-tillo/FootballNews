package com.example.footballnews.adapters.rvadapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballnews.R
import com.example.footballnews.databinding.ItemGameBinding
import com.example.footballnews.databinding.ItemRvBinding
import com.example.footballnews.models.FutboluzItem

class HomeAdapter(var context: Context) :
    ListAdapter<FutboluzItem, HomeAdapter.Vh>(MyDiffUtil()) {

    class MyDiffUtil : DiffUtil.ItemCallback<FutboluzItem>() {
        override fun areItemsTheSame(
            oldItem: FutboluzItem,
            newItem: FutboluzItem,
        ): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: FutboluzItem,
            newItem: FutboluzItem,
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class Vh(var itemImageBinding: ItemGameBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val item = getItem(position)
        holder.itemImageBinding.apply {

            name1.text = item.teamA
            Glide.with(context).load(item.logoTeamA).into(gamer1)

            turnamentname.text = item.tournamentName
            time.text = item.time
            shot.text = item.goals

            name2.text = item.teamH
            Glide.with(context).load(item.logoTeamH).into(gamer2)

        }
    }
}