package com.food.domain.usecase

import com.food.common.Resource
import kotlinx.coroutines.flow.Flow

interface IsRecipeSavedUseCaseInt {
     operator fun invoke(recipeId: Int): Flow<Resource<Boolean>>

}