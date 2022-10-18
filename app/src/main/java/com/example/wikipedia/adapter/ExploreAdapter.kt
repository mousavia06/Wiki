package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter (private val data : ArrayList<ItemPost>) :RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ItemExploreBinding
    inner class ExploreViewHolder(itemView :View) :RecyclerView.ViewHolder(itemView){

        fun bindView (position: Int) {
            Glide.with(itemView.context)
                .load(data[position].url)
                .into(binding.imgExplore)
            binding.txtExploreTitle.text = data[position].title
            binding.txtExploreSubtitle.text = data[position].subTitle
            binding.txtExploreDetail.text = data[position].detail
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}