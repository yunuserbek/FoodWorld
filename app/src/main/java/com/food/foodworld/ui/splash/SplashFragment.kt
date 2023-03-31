package com.food.foodworld.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.food.foodworld.utility.delegation.viewBinding
import com.food.foodworld.R
import com.food.foodworld.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.animLotti.playAnimation()
        CoroutineScope(Dispatchers.Main).launch {
            delay(2200)
            val animation = AnimationUtils.loadAnimation(
                requireContext(),
                R.anim.zoom_in
            )
            binding.animLotti.startAnimation(animation)
            delay(300)
            findNavController().navigate(R.id.action_splashFragment_to_foodFragment)
        }


    }

}