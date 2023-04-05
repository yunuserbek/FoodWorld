package com.food.foodworld.ui.Category


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.food.common.model.RandomUIModel
import com.food.foodworld.databinding.ItemCategoryDetailBinding

class CategoryAdapter() :
    ListAdapter<RandomUIModel, CategoryAdapter.CategoryViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(private var binding: ItemCategoryDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RandomUIModel) {
            Glide.with(binding.root).load(item.image).into(binding.ivRecipe)
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<RandomUIModel>() {


        override fun areItemsTheSame(oldItem: RandomUIModel, newItem: RandomUIModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RandomUIModel, newItem: RandomUIModel) =
            oldItem == newItem
    }
}