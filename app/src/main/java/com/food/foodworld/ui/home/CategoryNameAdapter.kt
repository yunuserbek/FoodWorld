package com.food.foodworld.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.food.domain.model.Menu
import com.food.foodworld.R
import com.food.foodworld.databinding.ItemCategoriesNameBinding
import com.food.foodworld.utility.ClickedAny
import com.food.foodworld.utility.circularProgressDrawable

class CategoryNameAdapter(private val foodList: List<Menu>, private val menuInterface: ClickedAny) :
    RecyclerView.Adapter<CategoryNameAdapter.NameViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val binding =ItemCategoriesNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameViewHolder(binding)
    }


    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    inner class NameViewHolder(private val binding: ItemCategoriesNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(food :Menu){
                binding.root.setOnClickListener {
                    menuInterface.onClickedAny(title = food.title, id = food.id)
                }

                itemView.animation = AnimationUtils.loadAnimation(itemView.context, R.anim.menu_category_item_scale)
                Glide.with(binding.imgKategori).load(food.image).into(binding.imgKategori)
                binding.tvKategori.text = food.title
                 //binding.cvKategori.setBackgroundColor(binding.cvKategori.context.getColor(food.backgroundColor))

//
            }

    }

}