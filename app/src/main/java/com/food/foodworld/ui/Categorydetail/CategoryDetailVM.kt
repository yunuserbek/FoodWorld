package com.food.foodworld.ui.Categorydetail

import androidx.lifecycle.SAVED_STATE_REGISTRY_OWNER_KEY
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.data.common.Constants.STATE_KEY_RECIPE_ID
import com.food.domain.usecaseImpl.AddRecipeUseCase
import com.food.domain.usecaseImpl.CategoryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryDetailVM @Inject constructor(

    private val categoryDetailUseCase: CategoryDetailUseCase,
    private val addRecipeUseCase: AddRecipeUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    init {
        savedStateHandle.get<Int>(STATE_KEY_RECIPE_ID)?.let {
            getDetail(it)
        }
    }


   private val _categoryDetail = MutableStateFlow<Resource<CategoryDetailUIModel>>(Resource.Loading)
    val categoryDetail get() = _categoryDetail.asStateFlow()


    fun getDetail(id: Int) = viewModelScope.launch {
        categoryDetailUseCase(id).collect {
            _categoryDetail.emit(it)
        }
    }
    fun addRecipe(recipe:CategoryDetailUIModel)=viewModelScope.launch {
        addRecipeUseCase.invoke(recipe)
    }
}