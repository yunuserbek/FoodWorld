package com.bahadir.mycookingapp.ui.recipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.food.common.model.CategoryDetailUIModel
import com.food.foodworld.ui.recipe.IngredientsFragment
import com.food.foodworld.ui.recipe.RecipeMadeFragment



class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val recipe: CategoryDetailUIModel
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return RecipeMadeFragment.newInstance(recipe)
        }
        return IngredientsFragment.newInstance(recipe)
    }
}


