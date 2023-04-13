package com.food.foodworld.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.food.foodworld.R
import com.food.foodworld.databinding.ActivityMainBinding
import com.food.foodworld.ui.splash.SplashFragment
import com.food.foodworld.utility.gone
import com.food.foodworld.utility.visible
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navController) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.categoryDetailsFragment,R.id.splashFragment,R.id.categoryFragment -> {
                    binding.fifthNavigationView.gone()
                }
                else -> {
                    binding.fifthNavigationView.visible()
                }
            }
        }
        binding.fifthNavigationView.setupWithNavController(navController)

    }
}