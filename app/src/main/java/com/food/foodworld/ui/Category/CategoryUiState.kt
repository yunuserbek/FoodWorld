package com.food.foodworld.ui.Category

import androidx.annotation.StringRes
import androidx.paging.PagingData
import com.food.common.model.RandomUIModel

sealed class CategoryUiState {
    object Loading : CategoryUiState()
    data class Success(val data: PagingData<RandomUIModel>) : CategoryUiState()
    data class Error(@StringRes val message: Int) : CategoryUiState()
}


