package com.food.foodworld.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.domain.usecase.RandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(private var randomUseCase: RandomUseCase) : ViewModel() {
    private  val _randomFood = MutableStateFlow<Resource<List<RandomUIModel>>>(
        Resource.Loading)
    val randomFood get() = _randomFood



    fun getRandomFood(count:Int) = viewModelScope.launch {

        randomUseCase(count).collect {
            _randomFood.emit(it)
        }
    }
}