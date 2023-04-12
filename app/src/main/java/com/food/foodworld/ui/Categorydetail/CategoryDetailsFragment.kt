package com.food.foodworld.ui.Categorydetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.domain.usecaseImpl.CategoryDetailUseCase
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentCategoryDetailsBinding
import com.food.foodworld.utility.glideImage
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import com.food.foodworld.utility.visibleOrGone
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CategoryDetailsFragment  : Fragment() {
    private val viewModel: CategoryDetailVM by viewModels()
    private val args: CategoryDetailsFragmentArgs by navArgs()

private lateinit var binding: FragmentCategoryDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryDetail()

    }
    private fun categoryDetail() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.categoryDetail.collect{
            when(it){
                is Resource.Loading->{
                    binding.animLoading.visible()
                }
                is Resource.Success->{
                    binding.animLoading.gone()
                    DetailCategory(it.data)
                }
                else -> {
                    binding.animLoading.gone()
                }
            }
        }

    }
    private fun foodImage(url: String) {
        binding.foodImage.glideImage(url)
    }

    private fun DetailCategory(item:CategoryDetailUIModel)= with(binding){
        foodImage(item.image)
        foodName.text = item.title
        gluten.visibleOrGone(item.glutenFree)
        vegan.visibleOrGone(item.vegetarian)
        gluten.visibleOrGone(item.glutenFree)
        vegan.visibleOrGone(item.vegetarian)
        lactose.visibleOrGone(item.dairyFree)
        cheap.visibleOrGone(item.cheap)
        popularity.visibleOrGone(item.veryPopular)
        healthy.visibleOrGone(item.veryHealthy)





}

}