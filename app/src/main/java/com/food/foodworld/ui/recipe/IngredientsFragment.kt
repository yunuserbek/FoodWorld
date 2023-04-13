package com.food.foodworld.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.food.common.model.CategoryDetailUIModel
import com.food.data.common.Constants
import com.food.data.common.Constants.RecipeMade
import com.food.foodworld.databinding.FragmentIngredientBinding


class IngredientsFragment : Fragment() {

    private lateinit var binding: FragmentIngredientBinding
    private val ıngredientsAdapter by lazy { IngredientsAdapter() }
    private var recipe :CategoryDetailUIModel ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIngredientBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipe = arguments?.getParcelable(RecipeMade)
        ıngredientsAdapter.submitList(recipe?.extendedIngredients)
        binding.rvIng.adapter = ıngredientsAdapter

    }

    companion object {
        fun newInstance(madeRecipe:CategoryDetailUIModel)=IngredientsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(RecipeMade,madeRecipe)
            }
        }
    }


}