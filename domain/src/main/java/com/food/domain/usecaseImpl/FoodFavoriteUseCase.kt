package com.food.domain.usecaseImpl

import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.FoodFavoriteUseCaseInt
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodFavoriteUseCase @Inject constructor(private val repository: FoodRepository):FoodFavoriteUseCaseInt {
    override fun invoke(): Flow<Resource<List<CategoryDetailUIModel>>> =repository.getFavoriteRecipes()
}