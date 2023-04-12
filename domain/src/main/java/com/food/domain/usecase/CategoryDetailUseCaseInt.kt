package com.food.domain.usecase

import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import kotlinx.coroutines.flow.Flow

interface CategoryDetailUseCaseInt {
    operator fun invoke(category:Int): Flow<Resource<CategoryDetailUIModel>>
}