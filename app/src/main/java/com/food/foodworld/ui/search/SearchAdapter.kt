package com.food.foodworld.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.food.common.model.SearchUIModel
import com.food.foodworld.R
import com.food.foodworld.databinding.ItemSearchRecipeBinding
import com.food.foodworld.utility.ClickedAny
import com.food.foodworld.utility.glideImage

class SearchAdapter(private val searchList: List<SearchUIModel>,
                    private val searchClickInterface: ClickedAny) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
  inner  class SearchViewHolder(private val binding: ItemSearchRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchUIModel) {

            itemView.animation =
                AnimationUtils.loadAnimation(itemView.context, R.anim.menu_category_item_scale)
            binding.foodImage.glideImage(item.image)
            binding.title.text = item.title
            binding.root.setOnClickListener {
             searchClickInterface.onClickedAny(id = item.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        val binding =
            ItemSearchRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        return holder.bind(searchList[position])
    }

    override fun getItemCount(): Int {
        return searchList.size
    }


}