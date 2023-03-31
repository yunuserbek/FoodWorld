package com.food.foodworld.domain.repository


import com.food.foodworld.common.Resource
import com.food.foodworld.domain.model.RandomUIModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
fun getFood(count:Int): Flow<Resource<List<RandomUIModel>>>

}