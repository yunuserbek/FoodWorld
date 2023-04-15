package com.food.domain.usecase

import com.food.common.model.CategoryDetailUIModel

interface AddRecipeUseCaseInt {

    suspend operator fun invoke(recipe: CategoryDetailUIModel)
}