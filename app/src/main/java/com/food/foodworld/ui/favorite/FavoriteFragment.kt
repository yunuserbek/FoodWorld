package com.food.foodworld.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.food.common.Resource
import com.food.foodworld.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private val favoriteAdapter by lazy { FavoriteAdapter() }


    private val viewModel: FavoriteVM by viewModels()

    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavoriteRecipes()
        collectData()
    }

    fun collectData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllRecipe.collect {response->

                when(response){
                    is Resource.Loading->{

                    }
                    is Resource.Success->{

                       favoriteAdapter.submitList(response.data)
                        binding.fovoriteRv.adapter = favoriteAdapter
                    }
                    is Resource.Error->{
                    }
                }

            }
        }
    }


}