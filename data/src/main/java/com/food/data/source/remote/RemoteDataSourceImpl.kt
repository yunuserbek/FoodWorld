package com.food.data.source.remote

import com.food.common.remote.RandomFood
import com.food.domain.source.remote.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor (private val foodServices: FoodServices) :
    RemoteDataSource {
    override suspend fun getRandomFood(count:Int): RandomFood = foodServices.getRandomFood(count)
}