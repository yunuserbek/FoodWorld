package com.food.foodworld

import androidx.fragment.app.Fragment
import com.example.gameinformation.common.delegation.viewBinding
import com.food.foodworld.databinding.FragmentFoodBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FoodFragment : Fragment(R.layout.fragment_food) {
    private val binding by viewBinding(FragmentFoodBinding::bind)

}