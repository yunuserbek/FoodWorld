package com.food.foodworld.ui.Category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.domain.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject
@HiltViewModel
class CategoryVM @Inject constructor(private val categoryUseCase: CategoryUseCase) : ViewModel() {


    private val _category = MutableStateFlow<Resource<List<RandomUIModel>>>(Resource.Loading)
    val category = _category.asStateFlow()

    fun categoryFood(number:Int,category:String) =viewModelScope.launch {

            categoryUseCase(number,category).collect {
                _category.emit(it)

        }
    }
}