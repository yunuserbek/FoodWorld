package com.food.domain.usecase

import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import kotlinx.coroutines.flow.Flow

interface FoodFavoriteUseCaseInt {
    operator fun invoke(): Flow<Resource<List<CategoryDetailUIModel>>>
}