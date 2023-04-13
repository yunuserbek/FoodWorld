package com.food.foodworld.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.food.common.model.CategoryDetailUIModel
import com.food.data.common.Constants
import com.food.data.common.Constants.RecipeMade
import com.food.foodworld.databinding.FragmentRecipeMadeBinding


class RecipeMadeFragment : Fragment() {
    private var recipe :CategoryDetailUIModel ?=null
    private lateinit var binding: FragmentRecipeMadeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeMadeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipe = arguments?.getParcelable(RecipeMade)
        Toast.makeText(requireContext(), recipe?.title, Toast.LENGTH_SHORT).show()

    }

    companion object {
        fun newInstance(
            madeRecipe: CategoryDetailUIModel
        ) = RecipeMadeFragment().apply {
            arguments = Bundle().apply {
                putParcelable(RecipeMade, madeRecipe)
            }
        }
    }

}