package com.food.foodworld.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.food.common.Resource
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentHomeBinding
import com.food.foodworld.utility.*
import com.food.foodworld.utility.delegation.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) ,ClickedAny{
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeVM by viewModels()

    private val randomAdapter by lazy { RandomAdapter() }
    lateinit var categoryNameAdapter: CategoryNameAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRandomFood(10)


        collectData()
        category()
    }

    private fun collectData() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.randomFood.collect { response ->
            when (response) {
                is Resource.Loading ->
                    binding.animLoading.visible()

                is Resource.Success -> {
                    binding.animLoading.isVisible = false
                    randomAdapter.updateList(response.data)
                    binding.recyclerRandom.adapter = randomAdapter

                }
                is Resource.Error -> {
                    binding.animLoading.gone()

                }
            }



        }
    }
    private fun category(){
      categoryNameAdapter = CategoryNameAdapter(viewModel.getMenu(),this)
        binding.recyclerMenu.adapter =categoryNameAdapter
    }

    override fun onClickedAny(id: Int?, title: String?) {
        context?.showToast(title.toString())
        context?.showToast(id.toString())

    }

}