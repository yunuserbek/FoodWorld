package com.food.foodworld.data.source.remote

import com.food.foodworld.data.remote.RandomFood
import com.food.foodworld.domain.source.remote.RemoteDataSource

class RemoteDataSourceImpl(private val foodServices: FoodServices) : RemoteDataSource {
    override suspend fun getRandomFood(): RandomFood = foodServices.getRandomFood()
}