package com.food.domain.usecase

import com.food.common.Resource
import com.food.common.model.RandomUIModel
import kotlinx.coroutines.flow.Flow

interface RandomUseCase {
   operator fun invoke(count:Int): Flow<Resource<List<RandomUIModel>>>
}