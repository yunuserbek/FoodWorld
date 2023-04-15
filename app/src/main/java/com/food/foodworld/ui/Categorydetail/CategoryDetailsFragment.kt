package com.food.foodworld.ui.Categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bahadir.mycookingapp.ui.recipe.ViewPagerAdapter
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentCategoryDetailsBinding
import com.food.foodworld.utility.glideImage
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import com.food.foodworld.utility.visibleOrGone
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryDetailsFragment  : Fragment() {
    private val viewModel: CategoryDetailVM by viewModels()
    private val args: CategoryDetailsFragmentArgs by navArgs()
    private var isTheRecipeSaved: Boolean = false

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

    private fun initUI(recipe:CategoryDetailUIModel) {
        binding.favorite.setOnClickListener {
            isTheRecipeSaved = when (isTheRecipeSaved) {
                true -> {
                    binding.favorite.setImageResource(R.drawable.star_off)
                    false
                }
                false -> {
                    viewModel.addRecipe(recipe)
                    binding.favorite.setImageResource(R.drawable.star_on)
                    true
                }
            }
        }

    }

    private fun foodImage(url: String) {
        binding.foodImage.glideImage(url)
    }

    fun initView(recipe: CategoryDetailUIModel) {
        val tabLayoutName = listOf("Ingredients", "Recipe")
        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager, lifecycle, recipe)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabLayoutName[position]
        }.attach()

    }

    private fun DetailCategory(item: CategoryDetailUIModel) = with(binding) {
        initView(item)
        initUI(item)
        foodImage(item.image)
        foodName.text = item.title
        gluten.visibleOrGone(item.glutenFree)
        vegan.visibleOrGone(item.vegetarian)
        lactose.visibleOrGone(item.dairyFree)
        cheap.visibleOrGone(item.cheap)
        popularity.visibleOrGone(item.veryPopular)
        healthy.visibleOrGone(item.veryHealthy)





}

}