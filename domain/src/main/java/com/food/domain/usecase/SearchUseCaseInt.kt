package com.food.domain.usecase

import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.common.model.SearchUIModel
import kotlinx.coroutines.flow.Flow

interface SearchUseCaseInt {
    suspend operator fun invoke(query: String): Flow<Resource<List<SearchUIModel>>>
}