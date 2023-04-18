package com.food.domain.usecaseImpl

import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.DeleteIdUseCaseInt
import javax.inject.Inject

class DeleteIdUseCase @Inject constructor(private val foodRepository: FoodRepository): DeleteIdUseCaseInt {
    override suspend fun invoke(id: Int) = foodRepository.deleteRecipe(id)
}