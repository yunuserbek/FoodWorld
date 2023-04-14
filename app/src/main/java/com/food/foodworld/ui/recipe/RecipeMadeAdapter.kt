package com.food.foodworld.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.food.common.model.StepUI
import com.food.foodworld.databinding.RecipeMadeItemBinding

class RecipeMadeAdapter : RecyclerView.Adapter<RecipeMadeAdapter.RecipeViewHolder>() {
    private val list = ArrayList<StepUI>()
    inner class RecipeViewHolder(private val binding: RecipeMadeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item:StepUI) {
            binding.apply {
                binding.itemName.text =item.step

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeMadeAdapter.RecipeViewHolder {
        val binding = RecipeMadeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
  return  RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeMadeAdapter.RecipeViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int =list.size


    fun updateList(updateList:List<StepUI>){
        this.list.clear()
        this.list.addAll(updateList)
        notifyItemRangeChanged(0,updateList.size)
    }
}