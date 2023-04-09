package com.food.foodworld.ui.Category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.food.domain.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryVM @Inject constructor(private val categoryUseCase: CategoryUseCase) : ViewModel() {
    private val _category = MutableStateFlow<CategoryUiState>(CategoryUiState.Loading)
    val category get() = _category.asStateFlow()

    fun categoryFood(category:String) =viewModelScope.launch {
            categoryUseCase(20,category).cachedIn(viewModelScope).collect {
                _category.value = CategoryUiState.Loading
                _category.value =CategoryUiState.Success(it)

        }
    }
}