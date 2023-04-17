package com.food.foodworld.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.domain.usecaseImpl.DeleteUseCase
import com.food.domain.usecaseImpl.FoodFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FavoriteVM @Inject constructor(private val favoriteUseCase: FoodFavoriteUseCase,private val deleteUseCase: DeleteUseCase):ViewModel() {

    private val _getAllRecipe = MutableStateFlow<Resource<List<CategoryDetailUIModel>>>(Resource.Loading)
    val getAllRecipe = _getAllRecipe.asStateFlow()

    private val _deleteRecipe = MutableStateFlow<Resource<CategoryDetailUIModel>>(Resource.Loading)
    val deleteRecipe = _deleteRecipe.asStateFlow()

fun getFavoriteRecipes() =viewModelScope.launch {
    favoriteUseCase.invoke().collect {
        _getAllRecipe.emit(it)
    }

}
    fun deleteRecipe(recipe:CategoryDetailUIModel)=viewModelScope.launch {
        deleteUseCase.invoke(recipe)
        getFavoriteRecipes()
    }


}