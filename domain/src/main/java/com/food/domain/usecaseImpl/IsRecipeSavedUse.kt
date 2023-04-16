package com.food.domain.usecaseImpl

import com.food.common.Resource
import com.food.domain.repository.FoodRepository
import com.food.domain.usecase.IsRecipeSavedUseCaseInt
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsRecipeSavedUse @Inject constructor(private val foodRepository: FoodRepository) : IsRecipeSavedUseCaseInt{
    override fun invoke(recipeId: Int): Flow<Resource<Boolean>>  = foodRepository.isRecipeSaved(recipeId)



}