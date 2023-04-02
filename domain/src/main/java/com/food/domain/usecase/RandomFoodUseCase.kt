package com.food.domain.usecase

import com.food.common.Resource
import com.food.common.model.RandomUIModel
import com.food.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RandomFoodUseCase @Inject constructor (private val foodRepository: FoodRepository):RandomUseCase{
    override fun invoke(count: Int): Flow<Resource<List<RandomUIModel>>> {
        return foodRepository.getFood(count)
    }

}