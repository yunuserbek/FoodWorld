package com.food.foodworld.ui.Category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.food.common.model.RandomUIModel
import com.food.domain.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryVM @Inject constructor(private val categoryUseCase: CategoryUseCase, private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _category = MutableStateFlow<PagingData<RandomUIModel>>(PagingData.empty())
    val category get() = _category.asStateFlow()
    init {
        categoryFood()
    }

   private fun categoryFood() =viewModelScope.launch {

        savedStateHandle.get<String>("categoryName")?.let {categoryname->
            categoryUseCase(20,categoryname).cachedIn(viewModelScope).collect {
                _category.emit(it)

            }
        }

    }
}