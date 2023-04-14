package com.food.foodworld.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.food.common.model.IngredientUI

import com.food.foodworld.databinding.ItemIcBinding
class IngredientsAdapter() :ListAdapter<IngredientUI, IngredientsAdapter.IngViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngViewHolder {
        val binding  = ItemIcBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

  inner class IngViewHolder(private val binding: ItemIcBinding) : RecyclerView.ViewHolder(binding.root){
      fun bind(item: IngredientUI) {
     Glide.with(binding.imgComponent).load(item.image).centerCrop().into(binding.imgComponent)
          binding.tvComponentName.text = item.original


      }
  }



    companion object DiffCallback : DiffUtil.ItemCallback<IngredientUI>() {


        override fun areItemsTheSame(oldItem: IngredientUI, newItem: IngredientUI) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: IngredientUI, newItem: IngredientUI) =
            oldItem == newItem
    }
}