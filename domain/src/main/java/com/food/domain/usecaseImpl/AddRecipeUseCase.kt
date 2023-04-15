package com.food.domain.usecaseImpl

import com.food.common.model.CategoryDetailUIModel
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.AddRecipeUseCaseInt
import javax.inject.Inject

class AddRecipeUseCase @Inject constructor(private val repository: FoodRepository): AddRecipeUseCaseInt {
    override suspend fun invoke(recipe: CategoryDetailUIModel) = repository.addRecipe(recipe)
}