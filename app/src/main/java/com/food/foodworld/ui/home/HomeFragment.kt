package com.food.foodworld.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gameinformation.common.delegation.viewBinding
import com.food.foodworld.R
import com.food.foodworld.common.Resource
import com.food.foodworld.common.extension.gone
import com.food.foodworld.common.extension.visible
import com.food.foodworld.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeVM by viewModels()
    private val randomAdapter by lazy { RandomAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

collectData()
    }

    private fun collectData() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.randomFood.collect { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.animLoading.visible()
                }
                is Resource.Success -> {
                    binding.animLoading.isVisible = false
                    randomAdapter.updateList(response.data)
                    binding.recyclerRandom.adapter =randomAdapter

                }
                is Resource.Error -> {
                    binding.animLoading.gone()
                    Log.e("throwable", response.throwable.toString())
                }
            }

        }
    }

}