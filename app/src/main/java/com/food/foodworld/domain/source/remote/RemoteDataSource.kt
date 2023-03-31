package com.food.foodworld.domain.source.remote

import com.food.foodworld.data.remote.RandomFood

interface RemoteDataSource {

suspend fun getRandomFood(): RandomFood
}