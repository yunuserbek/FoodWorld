package com.food.foodworld.ui.Category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.food.common.Resource
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentCategoryBinding
import com.food.foodworld.utility.delegation.viewBinding
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category) {

    private val args: CategoryFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentCategoryBinding::bind)
    private val viewModel: CategoryVM by viewModels()
    private val categoryAdapter by lazy { CategoryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category = args.categoryName
        viewModel.categoryFood(200, category)
        collectData()
    }

    private fun collectData() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.category.collect { response ->
            when (response) {
                is Resource.Loading -> {

                    binding.animLoading.visible()
                }
                is Resource.Success -> {
                    binding.animLoading.gone()
                    binding.rv.adapter = categoryAdapter
                    categoryAdapter.submitList(response.data)



                }
                is Resource.Error -> {


                }
            }
        }
    }

}