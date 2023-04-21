package com.food.foodworld.ui.Category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentCategoryBinding
import com.food.foodworld.utility.ClickedAny
import com.food.foodworld.utility.delegation.viewBinding
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.titleCaseFirstChar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category), ClickedAny {

    private val args: CategoryFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentCategoryBinding::bind)
    private val viewModel: CategoryVM by viewModels()
    private val categoryAdapter by lazy { CategoryAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectData()
        listener()
      binding.header.text =args.categoryName.titleCaseFirstChar()
    }


    private fun collectData() = viewLifecycleOwner.lifecycleScope.launch {

        viewModel.category.collect { response ->
            binding.animLoading.gone()
            binding.rv.adapter = categoryAdapter
            categoryAdapter.submitData(lifecycle, response)
        }
    }
    fun listener(){

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onClickedAny(id: Int?, title: String?) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailsFragment(id?:0,title?:"")
        findNavController().navigate(action)
    }

}