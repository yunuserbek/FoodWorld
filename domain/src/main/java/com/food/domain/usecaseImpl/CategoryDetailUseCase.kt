package com.food.domain.usecaseImpl

import com.food.common.Resource
import com.food.common.model.CategoryDetailUIModel
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.CategoryDetailUseCaseInt
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryDetailUseCase @Inject constructor(private val repository: FoodRepository):  CategoryDetailUseCaseInt{
    override fun invoke(category: Int): Flow<Resource<CategoryDetailUIModel>> {
        return  repository.getCategoryDetail(category)
    }


}