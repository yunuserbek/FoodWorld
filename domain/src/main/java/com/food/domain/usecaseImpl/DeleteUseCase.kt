package com.food.domain.usecaseImpl

import com.food.common.model.CategoryDetailUIModel
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.DeleteUseCaseInt
import javax.inject.Inject

class DeleteUseCase@Inject constructor(private val foodRepository: FoodRepository): DeleteUseCaseInt {
    override suspend fun invoke(recipeId: CategoryDetailUIModel) =foodRepository.deleteFavoriteRecipe(recipeId)
}