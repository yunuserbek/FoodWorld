package com.food.domain.usecase

import com.food.common.model.CategoryDetailUIModel

interface DeleteUseCaseInt {
suspend operator fun invoke (recipeId: CategoryDetailUIModel)
}