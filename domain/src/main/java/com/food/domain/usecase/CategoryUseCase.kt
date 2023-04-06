package com.food.domain.usecase

import androidx.paging.PagingData
import com.food.common.Resource
import com.food.common.model.RandomUIModel
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    operator fun invoke(number:Int,category:String): Flow<PagingData<RandomUIModel>>
}