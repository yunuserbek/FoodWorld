package com.food.domain.source.remote

import com.food.common.remote.RandomFood

interface RemoteDataSource {

suspend fun getRandomFood(count:Int): RandomFood
}