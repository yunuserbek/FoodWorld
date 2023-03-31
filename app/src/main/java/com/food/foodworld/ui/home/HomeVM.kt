package com.food.foodworld.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.foodworld.common.Resource
import com.food.foodworld.domain.model.RandomUIModel
import com.food.foodworld.domain.usecase.RandomFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(private var RandomUseCase: RandomFoodUseCase) : ViewModel() {
    private val _randomFood = MutableStateFlow<Resource<List<RandomUIModel>>>(Resource.Loading)
    val randomFood get() = _randomFood

    init {
        getRandomFood()
    }

    fun getRandomFood() = viewModelScope.launch {
        RandomUseCase.invoke().collect {
            _randomFood.emit(it)
        }
    }
}