package com.food.foodworld.ui.favorite


import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.food.common.model.CategoryDetailUIModel
import com.food.foodworld.R
import com.food.foodworld.databinding.ItemFavoriteRecipeBinding
import com.food.foodworld.utility.glideImage


class FavoriteAdapter() :
    ListAdapter<CategoryDetailUIModel, FavoriteAdapter.ViewHolder>(FavoriteItemCallBack()) {
    inner class ViewHolder(private val binding: ItemFavoriteRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryDetailUIModel) {
            with(binding) {
                itemView.animation =
                    AnimationUtils.loadAnimation(
                        itemView.context,
                        R.anim.favorite_item
                    )
                foodImage.glideImage(item.image)
                recipeText.text = item.title

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemFavoriteRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class FavoriteItemCallBack : DiffUtil.ItemCallback<CategoryDetailUIModel>() {
        override fun areItemsTheSame(
            oldItem: CategoryDetailUIModel, newItem: CategoryDetailUIModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryDetailUIModel, newItem: CategoryDetailUIModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }


}