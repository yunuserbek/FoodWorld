package com.food.foodworld.ui.Category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentCategoryBinding
import com.food.foodworld.utility.delegation.viewBinding


class CategoryFragment : Fragment(R.layout.fragment_category) {


    private val binding by viewBinding(FragmentCategoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}