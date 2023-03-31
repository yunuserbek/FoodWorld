package com.food.foodworld.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentHomeBinding
import com.food.foodworld.utility.delegation.viewBinding
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeVM by viewModels()

    private val randomAdapter by lazy { RandomAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
viewModel.getRandomFood(10)
collectData()
    }

    private fun collectData() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.randomFood.collect { response ->
            when (response) {
                is com.food.common.Resource.Loading -> {
                    binding.animLoading.visible()
                }
                is com.food.common.Resource.Success -> {
                    binding.animLoading.isVisible = false
                    randomAdapter.updateList(response.data)
                    binding.recyclerRandom.adapter = randomAdapter

                }
                is com.food.common.Resource.Error -> {
                    binding.animLoading.gone()

                }
            }

        }
    }

}