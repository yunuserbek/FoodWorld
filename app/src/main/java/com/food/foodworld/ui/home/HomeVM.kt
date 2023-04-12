package com.food.foodworld.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.domain.model.Menu
import com.food.domain.usecase.RandomUseCase
import com.food.foodworld.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(private var randomUseCase: RandomUseCase) : ViewModel() {
    private val _randomFood = MutableStateFlow<Resource<List<RandomUIModel>>>(Resource.Loading)
    val randomFood get() = _randomFood
    //  val randomFood =_randomFood.asStateFlow()


    fun getRandomFood(count: Int) = viewModelScope.launch {
        randomUseCase(count).collect {
            _randomFood.emit(it)

        }
    }


    fun getMenu(): List<Menu> {
        return listOf(
Menu(1, R.drawable.breakfast, "breakfast",-1),
Menu(2, R.drawable.aparatif, "appetizer",-1),
Menu(3, R.drawable.soup, "soup",-1),
Menu(4, R.drawable.maincourse, "main course",-1),
Menu(5, R.drawable.saladd, "salad",-1),
Menu(6, R.drawable.bread, "bread",-1),
Menu(7, R.drawable.drink, "drink",-1),
Menu(8, R.drawable.sweet, "sweet",-1),
        )
    }
}