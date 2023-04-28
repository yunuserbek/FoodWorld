package com.food.domain.usecaseImpl

import com.food.common.Resource
import com.food.common.model.SearchUIModel
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.SearchUseCaseInt
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: FoodRepository):SearchUseCaseInt {
    override suspend fun invoke(query: String): Flow<Resource<List<SearchUIModel>>> = repository.searchGet(query)

}