package com.food.foodworld.ui.Category


import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.food.common.model.RandomUIModel
import com.food.foodworld.R
import com.food.foodworld.databinding.ItemMenuBinding
import com.food.foodworld.utility.ClickedAny
import com.food.foodworld.utility.ColorText
import com.food.foodworld.utility.circularProgressDrawable
import com.food.foodworld.utility.setColor

class CategoryAdapter(private val menuInterface: ClickedAny) :
    PagingDataAdapter<RandomUIModel, CategoryAdapter.CategoryViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CategoryViewHolder(private var binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RandomUIModel) {
            binding.root.setOnClickListener {
                menuInterface.onClickedAny( id = item.id, title = item.title)
            }
            itemView.animation =
                AnimationUtils.loadAnimation(itemView.context, R.anim.menu_category_item_scale)
            Glide.with(binding.root).load(item.image).into(binding.ivRecipe)
            binding.tvNameRecipe.text = item.title
            when (item.healthScore) {
                in 1..24 -> binding.ratingBar.rating = 1f
                in 25..39 -> binding.ratingBar.rating = 1.5f
                in 40..44 -> binding.ratingBar.rating = 2f
                in 45..59 -> binding.ratingBar.rating = 2.5f
                in 60..64 -> binding.ratingBar.rating = 3f
                in 65..79 -> binding.ratingBar.rating = 3.5f
                in 80..84 -> binding.ratingBar.rating = 4f
                in 85..92 -> binding.ratingBar.rating = 4.5f
                else -> binding.ratingBar.rating = 5f

            }
            if (item.vegan){
                binding.veganIcon.setColor(R.color.green)
                binding.tvVegan.ColorText(R.color.green)
            }else{
                binding.veganIcon.setColor(R.color.gray400)
                binding.tvVegan.ColorText(R.color.gray400)

            }
            binding.clockIcon.setColor(R.color.orange)
            binding.tvClock.text = item.readyInMinutes.toString()
            binding.tvClock.ColorText(R.color.black)

        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<RandomUIModel>() {


        override fun areItemsTheSame(oldItem: RandomUIModel, newItem: RandomUIModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RandomUIModel, newItem: RandomUIModel) =
            oldItem == newItem
    }

}
