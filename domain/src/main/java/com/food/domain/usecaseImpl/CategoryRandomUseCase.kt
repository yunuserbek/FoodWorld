package com.food.domain.usecaseImpl

import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.CategoryUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRandomUseCase @Inject constructor (private val foodRepository:FoodRepository):CategoryUseCase {
    override fun invoke(number: Int, category: String): Flow<Resource<List<RandomUIModel>>> {
        return foodRepository.getFoodByCategory(number,category)
    }
}
