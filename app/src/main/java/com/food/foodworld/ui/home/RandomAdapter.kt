package com.food.foodworld.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.food.common.model.RandomUIModel
import com.food.foodworld.R
import com.food.foodworld.utility.glideImage
import com.food.foodworld.databinding.ItemHomeRandomBinding
import com.food.foodworld.utility.ClickedAny

class RandomAdapter( private val randomAdapter: ClickedAny) : RecyclerView.Adapter<RandomAdapter.RandomViewHolder>() {
    var itemlist = ArrayList<RandomUIModel>()





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {

        val binding = ItemHomeRandomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RandomViewHolder(binding)
    }


    override fun getItemCount(): Int = itemlist.size

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
     holder.bind(itemlist[position])
    }
    inner class RandomViewHolder(private var binding: ItemHomeRandomBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: RandomUIModel)= with(binding){
                binding.ivCategoryItem.glideImage(item.image)
                binding.tvCategoryName.text = item.title
               binding.root.setOnClickListener {
                   randomAdapter.onClickedAny(id =item.id)
               }



            }
    }

    fun updateList(updateList: List<RandomUIModel>) {
        this.itemlist.clear()
        this.itemlist.addAll(updateList)
        notifyItemRangeInserted(0, updateList.size)
    }

}