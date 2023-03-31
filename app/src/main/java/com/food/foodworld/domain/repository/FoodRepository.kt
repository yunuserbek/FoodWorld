package com.food.foodworld.domain.repository

import com.bumptech.glide.load.engine.Resource
import com.food.foodworld.domain.model.RandomUIModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
fun getFood(): Flow<Resource<Resource<RandomUIModel>>>

}