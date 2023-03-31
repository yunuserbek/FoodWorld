package com.food.foodworld.domain.usecase

import com.food.foodworld.domain.repository.FoodRepository
import javax.inject.Inject

class RandomFoodUseCase @Inject constructor (private val foodRepository:FoodRepository){
    operator fun invoke() = foodRepository.getFood()
}