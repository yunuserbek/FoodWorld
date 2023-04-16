package com.food.foodworld.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.food.common.Resource
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentHomeBinding
import com.food.foodworld.utility.ClickedAny
import com.food.foodworld.utility.delegation.viewBinding
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) ,ClickedAny{
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeVM by viewModels()

    private val randomAdapter by lazy { RandomAdapter() }
    private val categoryNameAdapter by lazy { CategoryNameAdapter(viewModel.getMenu(),this) }
  //  lateinit var categoryNameAdapter: CategoryNameAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRandomFood(10)

removeMenu()
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
                    binding.recyclerRandom.adapter = randomAdapter
                    randomAdapter.updateList(response.data)


                }
                is Resource.Error -> {
                    binding.animLoading.gone()

                }
            }



        }
    }
    private fun category(){
        binding.recyclerMenu.adapter =categoryNameAdapter
    }
    fun removeMenu(){
        val itemTouchHelper =ItemTouchHelper(categoryNameAdapter.getSimpleCallback())
        itemTouchHelper.attachToRecyclerView(binding.recyclerMenu)
    }

    override fun onClickedAny(id: Int?, title: String?) {

        val action =HomeFragmentDirections.actionFoodFragmentToCategoryFragment(title?:"")
      findNavController().navigate(action)

    }

}